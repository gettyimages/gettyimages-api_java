package com.gettyimages.Filters;

public enum SortOrder {
    BEST_MATCH("best_match"),
    MOST_POPULAR("most_popular"),
    NEWEST("newest");

    private String sortOrder;

    SortOrder(String sortOrder) {

        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return sortOrder;
    }
}
