package com.gettyimages.api.Filters;

public enum CollectionFilter {
    INCLUDE("include"),
    EXCLUDE("exclude");

    private String collectionFilter;

    CollectionFilter(String collectionFilter) {

        this.collectionFilter = collectionFilter;
    }

    @Override
    public String toString() {
        return collectionFilter;
    }
}
