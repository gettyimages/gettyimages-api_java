package com.gettyimages.search;

import com.gettyimages.search.filters.LicenseModel;

public interface BlendedImagesSearch<T> {

    CreativeImagesSearch creative();

    EditorialImagesSearch editorial();

    T withEndDate(String endDate);

    T withEventIds(String eventIds);

    T withGraphicalStyle(com.gettyimages.search.filters.GraphicalStyles graphicalStyle);

    T withLicenseModel(LicenseModel licenseModels);

    T withPrestigeContentOnly(boolean prestigeContentOnly);

    T withSpecificPeople(String specificPeople);

    T withStartDate(String startDate);
}
