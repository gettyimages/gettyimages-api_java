package com.gettyimages.Filters;

public enum FormatAvailable {
    SD("sd"),
    HD("hd"),
    FOUR_K("4k");

    private String format;

    FormatAvailable(String format) {

        this.format = format;
    }

    @Override
    public String toString() {
        return format;
    }
}
