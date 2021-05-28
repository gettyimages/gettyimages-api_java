package com.gettyimages.api.Filters;

public enum NumberOfPeople {
    NONE("none"),
    ONE("one"),
    TWO("two"),
    GROUP("group");

    private String numberOfPeople;

    NumberOfPeople(String numberOfPeople) {

        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return numberOfPeople;
    }
}
