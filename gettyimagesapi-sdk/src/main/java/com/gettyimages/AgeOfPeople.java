package com.gettyimages;

import java.util.HashMap;
import java.util.Map;

public enum AgeOfPeople {
    NONE(""),
    NEWBORN("newborn"),
    BABY("baby"),
    CHILD("child"),
    TEENAGER("teenager"),
    YOUNG_ADULT("young_adult"),
    ADULT("adult"),
    ADULTS_ONLY("adults_only"),
    MATURE_ADULT("mature_adult"),
    SENIOR_ADULT("senior_adult"),
    ZERO_TO_ONE_MONTHS("0-1_months"),
    TWO_TO_FIVE_MONTHS("2-5_months"),
    SIX_TO_ELEVEN_MONTHS("6-11_months"),
    TWELVE_TO_SEVENTEEN_MONTHS("12-17_months"),
    EIGHTEEN_TO_TWENTYTHREE_MONTHS("18-23_months"),
    TWO_TO_THREE_YEARS("2-3_years"),
    FOUR_TO_FIVE_YEARS("4-5_years"),
    SIX_TO_SEVEN_YEARS("6-7_years"),
    EIGHT_TO_NINE_YEARS("8-9_years"),
    TEN_TO_ELEVEN_YEARS("10-11_years"),
    TWELVE_TO_THIRTEEN_YEARS("12-13_years"),
    FOURTEEN_TO_FIFTEEN_YEARS("14-15_years"),
    SIXTEEN_TO_SEVENTEEN_YEARS("16-17_years"),
    EIGHTEEN_TO_NINETEEN_YEARS("18-19_years"),
    TWENTY_TO_TWENTYFOUR_YEARS("20-24_years"),
    TWENTY_TO_TWENTYNINE_YEARS("20-29_years"),
    TWENTYFIVE_TO_TWENTYNINE_YEARS("25-29_years"),
    THIRTY_TO_THIRTYFOUR_YEARS("30-34_years"),
    THIRTY_TO_THIRTYNINE_YEARS("30-39_years"),
    THIRTYFIVE_TO_THIRTYNINE_YEARS("35-39_years"),
    FOURTY_TO_FOURTYFOUR_YEARS("40-44_years"),
    FOURTY_TO_FOURTYNINE_YEARS("40-49_years"),
    FOURTYFIVE_TO_FOURTYNINE_YEARS("45-49_years"),
    FIFTY_TO_FIFTYFOUR_YEARS("50-54_years"),
    FIFTY_TO_FIFTYNINE_YEARS("50-59_years"),
    FIFTYFIVE_TO_FIFTYNINE_YEARS("55-59_years"),
    SIXTY_TO_SIXTYFOUR_YEARS("60-64_years"),
    SIXTY_TO_SIXTYNINE_YEARS("60-69_years"),
    SIXTYFIVE_TO_SIXTYNINE_YEARS("65-69_years"),
    SEVENTY_TO_SEVENTYNINE_YEARS("70-79_years"),
    EIGHTY_TO_EIGHTYNINE_YEARS("80-89_years"),
    NINETY_PLUS_YEARS("90_plus_years"),
    ONEHUNDRED_OVER("100_over");

    private String ageOfPeople;
    private static Map<String, AgeOfPeople> ageOfPeopleMap = new HashMap<>();

    static {
        ageOfPeopleMap.put("newborn",NEWBORN);
        ageOfPeopleMap.put("baby",BABY);
        ageOfPeopleMap.put("child",CHILD);
        ageOfPeopleMap.put("teenager",TEENAGER);
        ageOfPeopleMap.put("young_adult",YOUNG_ADULT);
        ageOfPeopleMap.put("adult",ADULT);
        ageOfPeopleMap.put("adults_only",ADULTS_ONLY);
        ageOfPeopleMap.put("mature_adult",MATURE_ADULT);
        ageOfPeopleMap.put("senior_adult",SENIOR_ADULT);
        ageOfPeopleMap.put("0-1_months",ZERO_TO_ONE_MONTHS);
        ageOfPeopleMap.put("2-5_months",TWO_TO_FIVE_MONTHS);
        ageOfPeopleMap.put("6-11_months",SIX_TO_ELEVEN_MONTHS);
        ageOfPeopleMap.put("12-17_months",TWELVE_TO_SEVENTEEN_MONTHS);
        ageOfPeopleMap.put("18-23_months",EIGHTEEN_TO_TWENTYTHREE_MONTHS);
        ageOfPeopleMap.put("2-3_years",TWO_TO_THREE_YEARS);
        ageOfPeopleMap.put("4-5_years",FOUR_TO_FIVE_YEARS);
        ageOfPeopleMap.put("6-7_years",SIX_TO_SEVEN_YEARS);
        ageOfPeopleMap.put("8-9_years",EIGHT_TO_NINE_YEARS);
        ageOfPeopleMap.put("10-11_years",TEN_TO_ELEVEN_YEARS);
        ageOfPeopleMap.put("12-13_years",TWELVE_TO_THIRTEEN_YEARS);
        ageOfPeopleMap.put("14-15_years",FOURTEEN_TO_FIFTEEN_YEARS);
        ageOfPeopleMap.put("16-17_years",SIXTEEN_TO_SEVENTEEN_YEARS);
        ageOfPeopleMap.put("18-19_years",EIGHTEEN_TO_NINETEEN_YEARS);
        ageOfPeopleMap.put("20-24_years",TWENTY_TO_TWENTYFOUR_YEARS);
        ageOfPeopleMap.put("20-29_years",TWENTY_TO_TWENTYNINE_YEARS);
        ageOfPeopleMap.put("25-29_years",TWENTYFIVE_TO_TWENTYNINE_YEARS);
        ageOfPeopleMap.put("30-34_years",THIRTY_TO_THIRTYFOUR_YEARS);
        ageOfPeopleMap.put("30-39_years",THIRTY_TO_THIRTYNINE_YEARS);
        ageOfPeopleMap.put("35-39_years",THIRTYFIVE_TO_THIRTYNINE_YEARS);
        ageOfPeopleMap.put("40-44_years",FOURTY_TO_FOURTYFOUR_YEARS);
        ageOfPeopleMap.put("40-49_years",FOURTY_TO_FOURTYNINE_YEARS);
        ageOfPeopleMap.put("45-49_years",FOURTYFIVE_TO_FOURTYNINE_YEARS);
        ageOfPeopleMap.put("50-54_years",FIFTY_TO_FIFTYFOUR_YEARS);
        ageOfPeopleMap.put("50-59_years",FIFTY_TO_FIFTYNINE_YEARS);
        ageOfPeopleMap.put("55-59_years",FIFTYFIVE_TO_FIFTYNINE_YEARS);
        ageOfPeopleMap.put("60-64_years",SIXTY_TO_SIXTYFOUR_YEARS);
        ageOfPeopleMap.put("60-69_years",SIXTY_TO_SIXTYNINE_YEARS);
        ageOfPeopleMap.put("65-69_years",SIXTYFIVE_TO_SIXTYNINE_YEARS);
        ageOfPeopleMap.put("70-79_years",SEVENTY_TO_SEVENTYNINE_YEARS);
        ageOfPeopleMap.put("80-89_years",EIGHTY_TO_EIGHTYNINE_YEARS);
        ageOfPeopleMap.put("90_plus_years",NINETY_PLUS_YEARS);
        ageOfPeopleMap.put("100_over",ONEHUNDRED_OVER);
    }
    AgeOfPeople(String ageOfPeople) {

        this.ageOfPeople = ageOfPeople;
    }

    @Override
    public String toString() {
        return ageOfPeople;
    }

    public static AgeOfPeople convert(String ageOfPeople) {
        return ageOfPeopleMap.get(ageOfPeople);
    }
}
