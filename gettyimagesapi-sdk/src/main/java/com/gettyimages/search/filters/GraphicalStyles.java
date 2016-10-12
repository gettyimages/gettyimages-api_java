package com.gettyimages.search.filters;

public enum GraphicalStyles
{
    NONE("none"),
    FINE_ART("fine_art"),
    PHOTOGRAPHY("photography"),
    ILLUSTRATION("illustration");

    /**
     * Used for query parameter naming during the REST call.
     */
    private String val;

    GraphicalStyles(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
