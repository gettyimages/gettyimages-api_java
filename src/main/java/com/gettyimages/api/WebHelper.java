package com.gettyimages.api;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;

public class WebHelper {
    protected String baseUrl;
    protected Credentials credentials;

    public WebHelper(Credentials credentials, String baseUrl) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
    }

    public String Get(Map queryParams, String path, Map headers) throws SdkException {
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url.toString());

            addHeaders(httpGet);
            headers.forEach((k, v)->{
                httpGet.addHeader(String.valueOf(k), String.valueOf(v));
            });

            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            String content = EntityUtils.toString(responseEntity);

            return content;
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        }

        return "{null}";
    }

    public String PostQuery(Map queryParams, String path, HttpEntity body, Map headers) throws SdkException {
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url.toString());

            addHeaders(httpPost);
            headers.forEach((k, v)->{
                httpPost.addHeader(String.valueOf(k), String.valueOf(v));
            });

            if (body != null) {
                httpPost.addHeader("content-type", "application/json");
                httpPost.setEntity(body);
            }

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

    public String PutQuery(Map queryParams, String path, HttpEntity body, Map headers) throws SdkException {
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPut httpPut = new HttpPut(url.toString());

            addHeaders(httpPut);
            headers.forEach((k, v)->{
                httpPut.addHeader(String.valueOf(k), String.valueOf(v));
            });

            if (body != null) {
                httpPut.addHeader("content-type", "application/json");
                httpPut.setEntity(body);
            }

            HttpResponse response = httpClient.execute(httpPut);
            HttpEntity responseEntity = response.getEntity();

            String content;
            if (responseEntity != null) {
                content = EntityUtils.toString(responseEntity);
            }
            else {
                content = "{}";
            }

            return content;
        } catch (MalformedURLException ex) {
            String s = ex.toString();
        } catch (IOException ex) {
            String s = ex.toString();
        }
        return null;
    }

    public String DeleteQuery(Map queryParams, String path, Map headers) throws SdkException {
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpDelete httpDelete = new HttpDelete(url.toString());

            addHeaders(httpDelete);
            headers.forEach((k, v)->{
                httpDelete.addHeader(String.valueOf(k), String.valueOf(v));
            });

            HttpResponse response = httpClient.execute(httpDelete);
            HttpEntity responseEntity = response.getEntity();
            String content;
            if (responseEntity != null) {
                content = EntityUtils.toString(responseEntity);
            }
            else {
                content = "{}";
            }

            return content;
        } catch (MalformedURLException ex) {
            String s = ex.toString();
        } catch (IOException ex) {
            String s = ex.toString();
        }
        return null;
    }

    private void addHeaders(HttpRequest request) throws SdkException {
        switch (credentials.CredentialType) {
            case ApiKey: {
                request.addHeader("Api-Key", credentials.ApiKey);
                break;
            }
            case ClientCredentials:
            case ResourceOwner: {
                request.addHeader("Api-Key", credentials.ApiKey);
                request.addHeader("Authorization", "Bearer " + credentials.GetAccessToken().getTokenString());
                break;
            }
        }

        request.addHeader("User-Agent", getUserAgent());
    }

    private String getUserAgent()
    {
        String httpAgentString = "";
        Properties properties = System.getProperties();

        String httpAgent = System.getProperty("http.agent");
        if (httpAgent != null) {
            httpAgentString = httpAgent.replace(")", "").replace(" (", "; ");
        }
        else {
            String osName = System.getProperty("os.name");
            String osArch = System.getProperty("os.arch");
            String javaVersion = System.getProperty("java.version");

            httpAgentString = String.format("%s; %s; Java %s", osName, osArch, javaVersion);
        }

        String userAgentString = String.format("GettyImagesSDK/%s (%s)", ApiClient.Version, httpAgentString);
        return userAgentString;
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
