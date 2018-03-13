package com.gettyimages.Filters;

public enum MinimumQualityRank {
    ONE("1"),
    TWO("2"),
    THREE("3");

    private String minimumQualityRank;

    MinimumQualityRank(String minimumQualityRank) {

        this.minimumQualityRank = minimumQualityRank;
    }

    @Override
    public String toString() {
        return minimumQualityRank;
    }
}
