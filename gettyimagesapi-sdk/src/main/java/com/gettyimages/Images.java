package com.gettyimages;

import java.util.ArrayList;
import java.util.List;

public class Images extends AbstractApiRequest{
    private String MustSpecifyAtLeastOneImageIdMessage = "Must specify at least one image id.";
    private String ImagesPath = "/images";
    private List<String> imageIds = new ArrayList<String>();

    private Images(Credentials credentials, String baseUrl)
    {
        super(credentials, baseUrl);
    }

    public static Images GetInstance(Credentials credentials, String baseUrl)
    {
        return new Images(credentials, baseUrl);
    }

    public String executeAsync() throws SdkException {
        if (imageIds.isEmpty())
        {
            throw new SdkException(MustSpecifyAtLeastOneImageIdMessage);
        }
        method = "GET";
        path = ImagesPath;
        if (imageIds.size() > 1 ) {
            queryParams.put(Constants.IdsParameterName, imageIds);
        }
        else {
            String id = String.join(",", imageIds);
            path = ImagesPath + "/" + id;
        }

        return super.executeAsync();
    }

    public Images withId(String val)
    {
        imageIds.add(val);
        return this;
    }

    public Images withIds(List<String> ids)
    {
        imageIds.addAll(ids);
        return this;
    }

    public Images withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }
}

