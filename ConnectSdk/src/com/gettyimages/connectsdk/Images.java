package com.gettyimages.connectsdk;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Images {
    private String MustSpecifyAtLeastOneImageIdMessage = "Must specify at least one image id.";
    private String FieldsKey = "fields";
    private String ImagesPath = "/images/";
    private String baseUrl;
    private Credentials credentials;
    private List<String> fields = new ArrayList<String>();
    private List<String> imageIds = new ArrayList<String>();

    private Images(Credentials credentials, String baseUrl)
    {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
    }

    public static Images GetInstance(Credentials credentials, String baseUrl)
    {
        return new Images(credentials, baseUrl);
    }

    public Images WithId(String val)
    {
        imageIds.add(val);
        return this;
    }

    public Images WithIds(List<String> ids)
    {
        imageIds.addAll(ids);
        return this;
    }

    public Images WithField(String value)
    {
        if (!fields.contains(value))
        {
            fields.add(value);
        }

        return this;
    }

    public String ExecuteAsync() throws SdkException {
        if (imageIds.isEmpty())
        {
            throw new SdkException(MustSpecifyAtLeastOneImageIdMessage);
        }

        WebHelper helper = new WebHelper(credentials, baseUrl);
        String ids = join(imageIds, ",");
        Map queryParams = new Hashtable<String, String>();

        if (!fields.isEmpty())
        {
            queryParams.put(FieldsKey, join(fields, ","));
        }

        String path = ImagesPath + ids;
        return helper.Get(queryParams, path);
    }

    public static String join(List<String> list, String delim) {

        StringBuilder sb = new StringBuilder();

        String loopDelim = "";

        for(String s : list) {

            sb.append(loopDelim);
            sb.append(s);

            loopDelim = delim;
        }

        return sb.toString();
    }
}

