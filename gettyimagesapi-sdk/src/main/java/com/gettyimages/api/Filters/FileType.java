package com.gettyimages.api.Filters;

public enum FileType {
    EPS("eps"),
    GIF("gif"),
    JPG("jpg"),
    PNG("png"),;

    private String fileType;

    FileType(String fileType) {

        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return fileType;
    }
}
