package com.gettyimages.api;

import org.apache.http.StatusLine;

public class HttpSystemErrorException extends SdkException {

    private final int statusCode;
    private final String reasonPhrase;

    public HttpSystemErrorException(final StatusLine statusLine) {
        super("System Error (" + statusLine.getStatusCode() + "): " + statusLine.getReasonPhrase());
        this.statusCode = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public HttpSystemErrorException(final Exception e) {
        super("System Error (500): Unexpected Error");
        this.statusCode = 500;
        this.reasonPhrase = "UnexpectedError"; // TODO: de-dupe
    }
}