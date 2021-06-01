package com.gettyimages.api.Filters;

public enum EditorialGraphicalStyles
{
    NONE("none"),
    PHOTOGRAPHY("photography"),
    ILLUSTRATION("illustration");

    private String style;

    EditorialGraphicalStyles(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return style;
    }
}
