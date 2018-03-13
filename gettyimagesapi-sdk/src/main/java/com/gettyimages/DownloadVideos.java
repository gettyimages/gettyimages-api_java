package com.gettyimages;

import com.gettyimages.search.filters.FileType;
import com.gettyimages.search.filters.ProductType;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class DownloadVideos extends AbstractApiRequest {
    private String MustSpecifyAtLeastOneVideoIdMessage = "Must specify at least one video id.";
    private String DownloadsPathString = "/downloads/videos/";

    private String assetId;

    private DownloadVideos(Credentials credentials, String baseUrl)
    {
        super(credentials, baseUrl);
    }

    public static DownloadVideos GetInstance(Credentials credentials, String baseUrl)
    {
        return new DownloadVideos(credentials, baseUrl);
    }

    public String executeAsync() throws SdkException {
        if (assetId == null || assetId.length() == 0)
        {
            throw new SdkException(MustSpecifyAtLeastOneVideoIdMessage);
        }

        queryParams.put(Constants.AutoDownloadParameterName, false);

        method = "POST";
        path = DownloadsPathString + assetId;

        return super.executeAsync();
    }

    public DownloadVideos withId(String value)
    {
        assetId = value;
        return this;
    }

    public DownloadVideos withProductId(Integer value)
    {
        queryParams.put(Constants.ProductIdParameterName, value);
        return this;
    }

    public DownloadVideos withSize(String value)
    {
        queryParams.put(Constants.SizeParameterName, value);
        return this;
    }
}

