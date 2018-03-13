package com.gettyimages.Filters;

public enum Compositions {
    NONE(""),
    ABSTRACT("abstract"),
    CANDID("candid"),
    CLOSE_UP("close_up"),
    COPY_SPACE("copy_space"),
    CUT_OUT("cut_out"),
    FULL_FRAME("full_frame"),
    FULL_LENGTH("full_length"),
    HEADSHOT("headshot"),
    LOOKING_AT_CAMERA("looking_at_camera"),
    MACRO("macro"),
    PORTRAIT("portrait"),
    SPARSE("sparse"),
    STILL_LIFE("still_life"),
    THREE_QUARTER_LENGTH("three_quarter_length"),
    WAIST_UP("waist_up");

    private String composition;

    Compositions(String composition) {
        this.composition = composition;
    }

    @Override
    public String toString() {
        return composition;
    }
}
