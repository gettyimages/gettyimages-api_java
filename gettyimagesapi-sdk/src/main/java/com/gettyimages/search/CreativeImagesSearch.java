package com.gettyimages.search;

import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

public interface CreativeImagesSearch<T> {

    T withGraphicalStyle(GraphicalStyles graphicalStyle);

    T withLicenseModel(LicenseModel licenseModels);

    T withPrestigeContentOnly(boolean prestigeContentOnly);
}
