package com.gettyimages.Filters;

public enum EditorialVideoType {
    RAW("raw"),
    PRODUCED("produced");

    private String editorialVideoType;

    EditorialVideoType(String editorialVideoType) {

        this.editorialVideoType = editorialVideoType;
    }

    @Override
    public String toString() {
        return editorialVideoType;
    }
}
