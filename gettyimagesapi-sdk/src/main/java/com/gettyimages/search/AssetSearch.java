package com.gettyimages.search;

import com.gettyimages.search.filters.EditorialSegment;
import com.gettyimages.search.filters.ProductType;

/**
 * Forces implementing classes to use method chaining.
 */
public interface AssetSearch<T extends AssetSearch<T>> {
    T withEditorialSegment(EditorialSegment val);

    T withExcludeNudity(boolean val);

    T withKeywordIds(String keywordIds);

    T withPage(int val);

    T withPageSize(int val);

    T withPhrase(String val);

    T withProductType(ProductType productType);

    T withResponseField(String val);

    T withSortOrder(String val);
}
