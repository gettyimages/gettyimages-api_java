package com.gettyimages;

import com.gettyimages.search.filters.FileType;
import com.gettyimages.search.filters.ProductType;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class DownloadImages extends AbstractApiRequest {
    private String MustSpecifyAtLeastOneImageIdMessage = "Must specify at least one image id.";
    private String DownloadsPathString = "/downloads/images/";

    private String assetId;

    private DownloadImages(Credentials credentials, String baseUrl)
    {
        super(credentials, baseUrl);
    }

    public static DownloadImages GetInstance(Credentials credentials, String baseUrl)
    {
        return new DownloadImages(credentials, baseUrl);
    }

    public String executeAsync() throws SdkException {
        if (assetId == null || assetId.length() == 0)
        {
            throw new SdkException(MustSpecifyAtLeastOneImageIdMessage);
        }

        queryParams.put(Constants.AutoDownloadParameterName, false);

        method = "POST";
        path = DownloadsPathString + assetId;

        return super.executeAsync();
    }

    public DownloadImages withId(String value)
    {
        assetId = value;
        return this;
    }

    public DownloadImages withFileType(FileType value)
    {
        queryParams.put(Constants.FileTypeParameterName, value);
        return this;
    }

    public DownloadImages withHeight(String value)
    {
        queryParams.put(Constants.HeightParameterName, value);
        return this;
    }

    public DownloadImages withProductId(Integer value)
    {
        queryParams.put(Constants.ProductIdParameterName, value);
        return this;
    }

    public DownloadImages withProductType(ProductType value)
    {
        queryParams.put(Constants.ProductTypeParameterName, value);
        return this;
    }
}
