package com.gettyimages.api.Filters;

public enum FileType {
    EPS("eps"),
    JPG("jpg");

    private String fileType;

    FileType(String fileType) {

        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return fileType;
    }
}
