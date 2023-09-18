package com.gettyimages.api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.*;

public class Credentials {
    private String ClientIdKey = "client_id";
    private String ClientSecretKey = "client_secret";
    private String UsernameKey = "username";
    private String PasswordKey = "password";
    private String ClientCredentialsValue = "client_credentials";
    private String GrantTypeKey = "grant_type";
    private String Oauth2TokenPath = "/oauth2/token";
    private String RefreshTokenKey = "refresh_token";

    private String baseUrl;
    private Token accessToken;

    public String ApiKey;
    public String ApiSecret;
    public CredentialType CredentialType;
    public String RefreshToken;
    public String UserName;
    public String UserPassword;

    private Credentials(String apiKey, String apiSecret, String baseUrl) {
        this.baseUrl = baseUrl;
        CredentialType = CredentialType.ClientCredentials;
        ApiKey = apiKey;
        ApiSecret = apiSecret;
    }

    private Credentials(String apiKey, String apiSecret, String refreshToken, String baseUrl) {
        this.baseUrl = baseUrl;
        CredentialType = CredentialType.RefreshToken;
        ApiKey = apiKey;
        ApiSecret = apiSecret;
        RefreshToken = refreshToken;
    }

    private Credentials(String apiKey, String apiSecret, String userName, String userPassword, String baseUrl) {
        this.baseUrl = baseUrl;
        CredentialType = CredentialType.ResourceOwner;
        ApiKey = apiKey;
        ApiSecret = apiSecret;
        UserName = userName;
        UserPassword = userPassword;
    }

    public static Credentials GetInstance(String apiKey, String apiSecret, String baseUrl) {
        return new Credentials(apiKey, apiSecret, baseUrl);
    }

    public static Credentials GetInstance(String apiKey, String apiSecret, String refreshToken, String baseUrl) {
        return new Credentials(apiKey, apiSecret, refreshToken, baseUrl); //TODO change to accept refresh token
    }

    public static Credentials GetInstance(String apiKey, String apiSecret, String userName, String userPassword,
                                          String baseUrl) {
        return new Credentials(apiKey, apiSecret, userName, userPassword, baseUrl);
    }

    public Token GetAccessToken() throws SdkException {

        // "now" seems like a bad name.  The value is set to some time into the future to then
        // compare to the token expiration.  If the token expiration is equal to or after this 
        // time then we keep caching.
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, 5);

        // Bug?  This reads to me like we'll never cache the token.
        // It only returns the cached token if the CredentialType is all at once NOT: 
        // - ClientCredentials
        // - ResourceOwner
        // - RefreshToken
        // First, this doesn't seem right: you'd want to cache the token in the case of CC or RO, right?
        // Second, we don't offer any way to instantiate Credentials *except* for these cases.
        // That tells me we're never caching the token.
        // Keep caching as long as the token's expiration is equal to or after 5 minutes from now
        if (CredentialType != CredentialType.ClientCredentials && CredentialType != CredentialType.ResourceOwner && CredentialType != CredentialType.RefreshToken
                ||
                (accessToken != null && accessToken.getExpiration().compareTo(now.getTime()) >= 0)) {
            return accessToken;
        }

        WebHelper helper = new WebHelper(this, baseUrl);
        String response = PostForm(GetCredentialsDictionary(), Oauth2TokenPath);
        try {
            JSONObject json = (JSONObject) new JSONObject(response);

            accessToken = new Token();

            accessToken.setTokenString(json.getString("access_token"));

            if (CredentialType == CredentialType.ResourceOwner)
                accessToken.setRefreshTokenString(json.getString("refresh_token"));

            Calendar expiration = Calendar.getInstance();
            expiration.add(Calendar.SECOND, json.getInt("expires_in"));
            accessToken.setExpiration(expiration.getTime());

            return accessToken;
        } catch (JSONException e) {
            e.printStackTrace();
            throw new HttpSystemErrorException(e);
        }
    }

    public Map<String,String> GetCredentialsDictionary()
    {
        Map<String,String> dict = new Hashtable<String, String>();

        if (!StringHelper.isNullOrEmpty(ApiKey))
        {
            dict.put(ClientIdKey, ApiKey);
        }

        if (!StringHelper.isNullOrEmpty(ApiSecret))
        {
            dict.put(ClientSecretKey, ApiSecret);
        }

        if (!StringHelper.isNullOrEmpty(UserName))
        {
            dict.put(UsernameKey, UserName);
        }

        if (!StringHelper.isNullOrEmpty(UserPassword))
        {
            dict.put(PasswordKey, UserPassword);
        }

        if (!StringHelper.isNullOrEmpty(RefreshToken))
        {
            dict.put(RefreshTokenKey, RefreshToken);
        }

        switch (CredentialType)
        {
            case ClientCredentials:
                dict.put(GrantTypeKey, ClientCredentialsValue);
                break;
            case ResourceOwner:
                dict.put(GrantTypeKey, PasswordKey);
                break;
            case RefreshToken:
                dict.put(GrantTypeKey, RefreshTokenKey);
                break;
        }

        return dict;
    }

    public String PostForm(Map<String, String> formParameters, String path) throws SdkException {
        try {
            URL url = new URL(baseUrl + path);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url.toString());

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry entry : formParameters.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode >= 400 && statusCode <= 499) {
                throw new HttpClientErrorException(statusLine);
            } else if (statusCode >= 500 && statusCode <= 599) {
                throw new HttpSystemErrorException(statusLine);
            }

            HttpEntity responseEntity = response.getEntity();
            String content = EntityUtils.toString(responseEntity);

            return content;
        } catch (SdkException e) {
            throw e;
        }
        catch (Exception e) {
            throw new HttpSystemErrorException(e);
        }
    }
}
