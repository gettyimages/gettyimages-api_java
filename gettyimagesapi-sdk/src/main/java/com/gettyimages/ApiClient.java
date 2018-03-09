package com.gettyimages;

import com.gettyimages.search.Search;

/*
    Main entry point to the Connect API SDK
 */
public class ApiClient {
    public static String Version="1.0.1-beta";
    private String Slash = "/";
    private Credentials credentials;
    private String baseUrl = "https://connect.gettyimages.com/v3";

    private ApiClient(String apiKey, String apiSecret, String baseUrl) {
        this.baseUrl = baseUrl;
        credentials = Credentials.GetInstance(apiKey, apiSecret, this.baseUrl);
    }

    private ApiClient(String apiKey, String apiSecret) {
        NormalizeAndSetBaseUrl(baseUrl);
        credentials = Credentials.GetInstance(apiKey, apiSecret, GetOAuthBaseUrl());
    }

    private ApiClient(String apiKey, String apiSecret, String userName, String userPassword) {
        NormalizeAndSetBaseUrl(baseUrl);
        credentials = Credentials.GetInstance(apiKey, apiSecret, userName, userPassword, GetOAuthBaseUrl());
    }

    //CHECK ON DESIGN
//    public void setBaseUrl(String baseUrl) {
//        if (baseUrl != null) {
//            this.baseUrl = baseUrl;
//        }
//    }

    public static ApiClient GetApiClientWithClientCredentials(String apiKey, String apiSecret)
    {
        return new ApiClient(apiKey, apiSecret);
    }

    public static ApiClient GetApiClientWithClientCredentials(String apiKey, String apiSecret, String baseUrl)
    {
        return new ApiClient(apiKey, apiSecret, baseUrl);
    }

    public static ApiClient GetApiClientWithResourceOwnerCredentials(String apiKey, String apiSecret, String userName, String password)
    {
        return new ApiClient(apiKey, apiSecret, userName, password);
    }

    public Search search() {
        return Search.GetInstance(credentials, baseUrl);
    }

//    public Images Images()
//    {
//        return Images.GetInstance(credentials, baseUrl);
//    }

    public Download Download()
    {
        return Download.GetInstance(credentials, baseUrl);
    }

    private void NormalizeAndSetBaseUrl(String baseUrl) {
        baseUrl = baseUrl.endsWith(Slash) ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
    }

    private String GetOAuthBaseUrl() {
        String oAuthBaseUrl = baseUrl.substring(0, baseUrl.lastIndexOf(Slash));
        return oAuthBaseUrl;
    }
}
