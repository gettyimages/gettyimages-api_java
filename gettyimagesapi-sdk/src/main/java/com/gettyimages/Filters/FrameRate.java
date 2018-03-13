package com.gettyimages.Filters;

public enum FrameRate {
    FRAMERATE_23("23.98"),
    FRAMERATE_24("24"),
    FRAMERATE_25("25"),
    FRAMERATE_29("29.97"),
    FRAMERATE_30("30"),
    FRAMERATE_50("50"),
    FRAMERATE_59("59.94"),
    FRAMERATE_60("60");

    private String frameRate;

    FrameRate(String frameRate) {

        this.frameRate = frameRate;
    }

    @Override
    public String toString() {
        return frameRate;
    }
}
