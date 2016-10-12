package com.gettyimages.search;

import com.gettyimages.search.filters.EditorialGraphicalStyles;

/**
 * Created by jsantos on 9/29/16.
 */
public interface EditorialImagesSearch<T> {

    T withEndDate(String endDate);

    T withEventIds(String eventIds);

    T withGraphicalStyle(EditorialGraphicalStyles graphicalStyles);

    T withSpecificPeople(String specificPeople);

    T withStartDate(String startDate);
}
