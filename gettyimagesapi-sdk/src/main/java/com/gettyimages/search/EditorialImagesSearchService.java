package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.search.filters.EditorialGraphicalStyles;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class EditorialImagesSearchService extends AbstractImagesSearch implements EditorialImagesSearch<EditorialImagesSearchService>{

    public EditorialImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public String executeAsync() throws SdkException {
        Map<String, String> queryParams = new HashMap<>();
        if (!getEditorialGraphicalStyles().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (EditorialGraphicalStyles item : getEditorialGraphicalStyles()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(GraphicalStylesString, sb.toString());
        }
        setStringQueryParameter(StartDateParameterName, queryParams);
        setStringQueryParameter(EndDateParameterName, queryParams);
        setStringQueryParameter(SpecificPeopleParameterName, queryParams);
        setStringQueryParameter(EventIdsParameterName, queryParams);

        return this.executeAsync(queryParams);
    }

    @Override
    public EditorialImagesSearchService withEndDate(String endDate) {
        map.put(EndDateParameterName, endDate);
        return this;
    }

    @Override
    public EditorialImagesSearchService withEventIds(String ids) {
        map.put(EventIdsParameterName, ids);
        return this;
    }

    @Override
    public EditorialImagesSearchService withGraphicalStyle(EditorialGraphicalStyles graphicalStyles) {
        EnumSet<EditorialGraphicalStyles> segments;
        if (map.containsKey(GraphicalStylesString)) {
            segments = (EnumSet<EditorialGraphicalStyles>) map.get(GraphicalStylesString);
        } else {
            segments = EnumSet.noneOf(EditorialGraphicalStyles.class);
        }
        if (graphicalStyles != EditorialGraphicalStyles.NONE) {
            segments.add(graphicalStyles);
        }

        map.put(GraphicalStylesString, segments);
        return this;
    }

    @Override
    public EditorialImagesSearchService withSpecificPeople(String people) {
        map.put(SpecificPeopleParameterName, people);
        return this;
    }

    @Override
    public EditorialImagesSearchService withStartDate(String startDate) {
        map.put(StartDateParameterName, startDate);
        return this;
    }

    private EnumSet<EditorialGraphicalStyles> getEditorialGraphicalStyles() {
        if (!map.containsKey(GraphicalStylesString)) {
            return EnumSet.noneOf(EditorialGraphicalStyles.class);
        }
        return (EnumSet<EditorialGraphicalStyles>) map.get(GraphicalStylesString);
    }
}
