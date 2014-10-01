package com.gettyimages.connectsdk;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class WebHelper {
    protected String baseUrl;
    protected Credentials credentials;

    public WebHelper(Credentials credentials, String baseUrl) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
    }

    public String Get(Map queryParams, String path) throws SdkException {
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url.toString());

            addCredentials(httpGet);

            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            String content = EntityUtils.toString(responseEntity);

            return content;
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        }

        return "{null}";
    }

    public String PostQuery(Map<String, String> queryParams, String path) throws SdkException {
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url.toString());

            addCredentials(httpPost);

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

    private void addCredentials(HttpRequest request) throws SdkException {
        switch (credentials.CredentialType) {
            case ApiKey: {
                request.addHeader("Api-Key", credentials.ApiKey);
                break;
            }
            case ClientCredentials:
            case ResourceOwner: {
                request.addHeader("Api-Key", credentials.ApiKey);
                request.addHeader("Authorization", "Bearer " + credentials.GetAccessToken().TokenString);
                break;
            }
        }
    }

    private String BuildQuery(Map<?, ?> queryParams) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<?, ?> entry : queryParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }

        return sb.toString();
    }

    static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
