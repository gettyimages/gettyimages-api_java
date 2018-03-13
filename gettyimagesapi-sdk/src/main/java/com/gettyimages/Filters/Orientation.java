package com.gettyimages.Filters;

public enum Orientation
{
    NONE(""),
    HORIZONTAL("Horizontal"),
    PANORAMIC_HORIZONTAL("Vertical"),
    PANORAMIC_VERTICAL("Square"),
    SQUARE("PanoramicHorizontal"),
    VERTICAL("PanoramicVertical");

    private String orientation;

    Orientation(String orientation) {

        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return orientation;
    }
}
