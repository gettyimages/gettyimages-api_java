package com.gettyimages.CustomRequest;

import com.gettyimages.AbstractApiRequest;
import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONObject;

import java.util.Map;

public class CustomRequest extends AbstractApiRequest{

    private CustomRequest(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static CustomRequest GetInstance(Credentials credentials, String baseUrl) {
        return new CustomRequest(credentials, baseUrl);
    }

    public String executeAsync() throws SdkException {
        return super.executeAsync();
    }

    public CustomRequest withMethod(String value) {
        method = value;
        return this;
    }

    public CustomRequest withRoute(String value) {
        path = value;
        return this;
    }

    public CustomRequest withQueryParameters(Map value) {
        queryParams = value;
        return this;
    }

    public CustomRequest withBody(JSONObject value) throws Exception {
        HttpEntity entity = new ByteArrayEntity(value.toString().getBytes("UTF-8"));
        body = entity;
        return this;
    }

    public CustomRequest withBody(String value) throws Exception {
        HttpEntity entity = new ByteArrayEntity(value.getBytes("UTF-8"));
        body = entity;
        return this;
    }

    public CustomRequest withBody(ByteArrayEntity value) {
        body = value;
        return this;
    }
}
