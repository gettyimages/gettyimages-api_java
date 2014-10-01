package com.gettyimages.connectsdk;

import com.gettyimages.connectsdk.search.Search;

/*
    Main entry point to the Connect API SDK
 */
public class ConnectSdk {
    private String Slash = "/";
    private Credentials credentials;
    private String baseUrl = "https://connect.gettyimages.com/v3";

    public ConnectSdk(String apiKey, String apiSecret) {
        NormalizeAndSetBaseUrl(baseUrl);
        credentials = Credentials.GetInstance(apiKey, apiSecret, GetOAuthBaseUrl());
    }

    public ConnectSdk(String apiKey, String apiSecret, String userName, String userPassword) {
        NormalizeAndSetBaseUrl(baseUrl);
        credentials = Credentials.GetInstance(apiKey, apiSecret, userName, userPassword, GetOAuthBaseUrl());
    }

    public Search Search() {
        return Search.GetInstance(credentials, baseUrl);
    }

    public Images Images()
    {
        return Images.GetInstance(credentials, baseUrl);
    }

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
