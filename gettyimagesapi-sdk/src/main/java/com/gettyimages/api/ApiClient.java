package com.gettyimages.api;

import com.gettyimages.api.CustomRequest.CustomRequest;
import com.gettyimages.api.Downloads.DownloadImages;
import com.gettyimages.api.Downloads.DownloadVideos;
import com.gettyimages.api.Images.Images;
import com.gettyimages.api.Videos.Videos;
import com.gettyimages.api.Search.*;

/*
    Main entry point to the Connect API SDK
 */
public class ApiClient {
    public static String Version="1.0.1-beta";
    private String Slash = "/";
    private Credentials credentials;
    private static String baseUrl = "https://api.gettyimages.com/v3";

    private ApiClient(String apiKey, String apiSecret) {
        credentials = Credentials.GetInstance(apiKey, apiSecret, GetOAuthBaseUrl());
    }

    private ApiClient(String apiKey, String apiSecret, String userName, String userPassword) {
        credentials = Credentials.GetInstance(apiKey, apiSecret, userName, userPassword, GetOAuthBaseUrl());
    }

    public static ApiClient GetApiClientWithClientCredentials(String apiKey, String apiSecret)
    {
        return new ApiClient(apiKey, apiSecret);
    }

    public static ApiClient GetApiClientWithResourceOwnerCredentials(String apiKey, String apiSecret, String userName, String password)
    {
        return new ApiClient(apiKey, apiSecret, userName, password);
    }

    private String GetOAuthBaseUrl() {
        String oAuthBaseUrl = baseUrl.substring(0, baseUrl.lastIndexOf(Slash));
        return oAuthBaseUrl;
    }

    public Images images()
    {
        return Images.GetInstance(credentials, baseUrl);
    }

    public Videos videos()
    {
        return Videos.GetInstance(credentials, baseUrl);
    }

    public SearchImages searchimages() {
        return SearchImages.GetInstance(credentials, baseUrl);
    }

    public SearchImagesCreative searchimagescreative() {
        return SearchImagesCreative.GetInstance(credentials, baseUrl);
    }

    public SearchImagesEditorial searchimageseditorial() {
        return SearchImagesEditorial.GetInstance(credentials, baseUrl);
    }

    public SearchVideos searchvideos() {
        return SearchVideos.GetInstance(credentials, baseUrl);
    }

    public SearchVideosCreative searchvideoscreative() {
        return SearchVideosCreative.GetInstance(credentials, baseUrl);
    }

    public SearchVideosEditorial searchvideoseditorial() {
        return SearchVideosEditorial.GetInstance(credentials, baseUrl);
    }

    public DownloadVideos downloadvideos() {
        return DownloadVideos.GetInstance(credentials, baseUrl);
    }

    public DownloadImages downloadimages() {
        return DownloadImages.GetInstance(credentials, baseUrl);
    }

    public CustomRequest customrequest() {
        return CustomRequest.GetInstance(credentials, baseUrl);
    }
}
