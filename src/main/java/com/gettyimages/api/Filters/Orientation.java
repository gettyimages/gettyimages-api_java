package com.gettyimages.api.Filters;

public enum Orientation
{
    NONE(""),
    HORIZONTAL("Horizontal"),
    VERTICAL("Vertical"),
    SQUARE("Square"),
    PANORAMIC_HORIZONTAL("PanoramicHorizontal"),
    PANORAMIC_VERTICAL("PanoramicVertical");

    private String orientation;

    Orientation(String orientation) {

        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return orientation;
    }
}
