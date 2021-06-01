package com.gettyimages.api.Filters;

public enum MinimumSize {
    NONE("none"),
    XSMALL("x_small"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    XLARGE("x_large"),
    XXLARGE("xx_large");

    private String minimumSize;

    MinimumSize(String minimumSize) {

        this.minimumSize = minimumSize;
    }

    @Override
    public String toString() {
        return minimumSize;
    }
}
