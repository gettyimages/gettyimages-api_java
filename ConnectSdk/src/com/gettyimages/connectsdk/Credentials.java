package com.gettyimages.connectsdk;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Credentials {
    private String ClientIdKey = "client_id";
    private String ClientSecretKey = "client_secret";
    private String UsernameKey = "username";
    private String PasswordKey = "password";
    private String ClientCredentialsValue = "client_credentials";
    private String GrantTypeKey = "grant_type";
    private String Oauth2TokenPath = "/oauth2/token";

    private String baseUrl;
    private Token accessToken;

    public String ApiKey;
    public String ApiSecret;
    public CredentialType CredentialType;
    public Token RefreshToken;
    public String UserName;
    public String UserPassword;

    private Credentials(String apiKey, String apiSecret, String baseUrl) {
        this.baseUrl = baseUrl;
        CredentialType = CredentialType.ClientCredentials;
        ApiKey = apiKey;
        ApiSecret = apiSecret;
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

    public static Credentials GetInstance(String apiKey, String apiSecret, String userName, String userPassword,
                                          String baseUrl) {
        return new Credentials(apiKey, apiSecret, userName, userPassword, baseUrl);
    }

    public Token GetAccessToken() throws SdkException {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -5);

        if (CredentialType != CredentialType.ClientCredentials && CredentialType != CredentialType.ResourceOwner
                ||
                (accessToken != null && accessToken.Expiration.compareTo(now.getTime()) >= 0)) {
            return accessToken;
        }

        WebHelper helper = new WebHelper(this, baseUrl);
        String response = PostForm(GetCredentialsDictionary(), Oauth2TokenPath);
        try {
            JSONObject json = (JSONObject) new JSONObject(response);

            accessToken = new Token();

            accessToken.TokenString = json.getString("access_token");

            Calendar expiration = Calendar.getInstance();
            expiration.add(Calendar.SECOND, json.getInt("expires_in"));
            accessToken.Expiration = expiration.getTime();

            return accessToken;
        } catch (JSONException e) {
            e.printStackTrace();
            throw new SdkException("Unable to get access token. Probably invalid credentials.");
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

        switch (CredentialType)
        {
            case ClientCredentials:
                dict.put(GrantTypeKey, ClientCredentialsValue);
                break;
            case ResourceOwner:
                dict.put(GrantTypeKey, PasswordKey);
                break;
        }

        return dict;
    }

    public String PostForm(Map<String, String> formParameters, String path) {
        try {
            URL url = new URL(baseUrl + path);
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url.toString());

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry entry : formParameters.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String content = EntityUtils.toString(responseEntity);

            return content;
        } catch (MalformedURLException ex) {
            String s = ex.toString();
        } catch (IOException ex) {
            String s = ex.toString();
        }
        return null;
    }
}
