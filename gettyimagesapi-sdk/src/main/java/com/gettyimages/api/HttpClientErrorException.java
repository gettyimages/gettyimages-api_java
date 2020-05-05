package com.gettyimages.api;

import org.apache.http.StatusLine;

public class HttpClientErrorException extends SdkException {

    private final int statusCode;
    private final String reasonPhrase;
    
    public HttpClientErrorException(final StatusLine statusLine) {
            super("Client Error (" + statusLine.getStatusCode() + "): " + statusLine.getReasonPhrase());
        this.statusCode = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}