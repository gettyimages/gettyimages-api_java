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

    /**
     * @param value The type of HTTP method - GET, POST, PUT, or DELETE
     * @return CustomRequest
     */
    public CustomRequest withMethod(String value) {
        method = value;
        return this;
    }

    /**
     * @param value The route to append to "https://api.gettyimages.com/v3"
     * @return CustomRequest
     */
    public CustomRequest withRoute(String value) {
        path = value;
        return this;
    }

    /**
     * @param value A Map of key => value pairs where the key is the name of the parameter and the value is the associated value(s)
     * @return CustomRequest
     */
    public CustomRequest withQueryParameters(Map value) {
        queryParams = value;
        return this;
    }

    /**
     * @param value A JSONObject to be passed as the body of the request
     * @return CustomRequest
     */
    public CustomRequest withBody(JSONObject value) throws Exception {
        HttpEntity entity = new ByteArrayEntity(value.toString().getBytes("UTF-8"));
        body = entity;
        return this;
    }

    /**
     * @param value A String to be passed as the body of the request
     * @return CustomRequest
     */
    public CustomRequest withBody(String value) throws Exception {
        HttpEntity entity = new ByteArrayEntity(value.getBytes("UTF-8"));
        body = entity;
        return this;
    }

    /**
     * @param value A ByteArrayEntity to be passed as the body of the request
     * @return CustomRequest
     */
    public CustomRequest withBody(ByteArrayEntity value) {
        body = value;
        return this;
    }
}
