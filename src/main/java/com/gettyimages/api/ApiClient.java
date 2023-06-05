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
    public static String Version="2.1.1";
    private String Slash = "/";
    private Credentials credentials;
    private static String apiBaseUrl = "https://api.gettyimages.com/v3";
    private static String authenticationBaseUrl = "https://authentication.gettyimages.com";

    private ApiClient(String apiKey, String apiSecret) {
        credentials = Credentials.GetInstance(apiKey, apiSecret, authenticationBaseUrl);
    }

    private ApiClient(String apiKey, String apiSecret, String userName, String userPassword) {
        credentials = Credentials.GetInstance(apiKey, apiSecret, userName, userPassword, authenticationBaseUrl);
    }

    public static ApiClient GetApiClientWithClientCredentials(String apiKey, String apiSecret)
    {
        return new ApiClient(apiKey, apiSecret);
    }

    public static ApiClient GetApiClientWithResourceOwnerCredentials(String apiKey, String apiSecret, String userName, String password)
    {
        return new ApiClient(apiKey, apiSecret, userName, password);
    }

    public Images images()
    {
        return Images.GetInstance(credentials, apiBaseUrl);
    }

    public Videos videos()
    {
        return Videos.GetInstance(credentials, apiBaseUrl);
    }

    public SearchImages searchimages() {
        return SearchImages.GetInstance(credentials, apiBaseUrl);
    }

    public SearchImagesCreative searchimagescreative() {
        return SearchImagesCreative.GetInstance(credentials, apiBaseUrl);
    }

    public SearchImagesEditorial searchimageseditorial() {
        return SearchImagesEditorial.GetInstance(credentials, apiBaseUrl);
    }

    public SearchVideos searchvideos() {
        return SearchVideos.GetInstance(credentials, apiBaseUrl);
    }

    public SearchVideosCreative searchvideoscreative() {
        return SearchVideosCreative.GetInstance(credentials, apiBaseUrl);
    }

    public SearchVideosEditorial searchvideoseditorial() {
        return SearchVideosEditorial.GetInstance(credentials, apiBaseUrl);
    }

    public DownloadVideos downloadvideos() {
        return DownloadVideos.GetInstance(credentials, apiBaseUrl);
    }

    public DownloadImages downloadimages() {
        return DownloadImages.GetInstance(credentials, apiBaseUrl);
    }

    public CustomRequest customrequest() {
        return CustomRequest.GetInstance(credentials, apiBaseUrl);
    }
}
