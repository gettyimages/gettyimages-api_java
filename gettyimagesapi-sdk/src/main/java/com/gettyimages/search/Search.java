package com.gettyimages.search;

import com.gettyimages.Credentials;

public class Search {
    private String baseUrl;
    private Credentials credentials;

    private Search(Credentials credentials, String baseUrl) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
    }

    public static Search GetInstance(Credentials credentials, String baseUrl) {
        return new Search(credentials, baseUrl);
    }

    public BlendedImagesSearchService images() {
        return BlendedImagesSearchService.GetInstance(credentials, baseUrl);
    }
}
