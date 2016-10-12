package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

import java.util.*;

public class BlendedImagesSearchService extends AbstractImagesSearch implements BlendedImagesSearch<BlendedImagesSearch>{

    private final String EditorialString = "editorial";
    private final String CreativeString = "creative";

    private BlendedImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    public static BlendedImagesSearchService GetInstance(Credentials credentials, String baseUrl) {
        return new BlendedImagesSearchService(credentials, baseUrl, new Hashtable());
    }

    @Override
    public CreativeImagesSearchService creative() {
        map.put(AssetTypeString, CreativeString);
        return new CreativeImagesSearchService(credentials, baseUrl, map);
    }

    @Override
    public String executeAsync() throws SdkException {
        Map<String, String> queryParams = new HashMap<>();
        if (!getGraphicalStyles().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (GraphicalStyles item : getGraphicalStyles()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(GraphicalStylesString, sb.toString());
        }
        setStringQueryParameter(EndDateParameterName, queryParams);
        setStringQueryParameter(StartDateParameterName, queryParams);
        setStringQueryParameter(SpecificPeopleParameterName, queryParams);
        setStringQueryParameter(EventIdsParameterName, queryParams);
        setBooleanQueryParameter(PrestigeContentOnlyParameterName, queryParams);

        return this.executeAsync(queryParams);
    }

    @Override
    public EditorialImagesSearchService editorial() {
        map.put(AssetTypeString, EditorialString);
        return new EditorialImagesSearchService(credentials, baseUrl, map);
    }

    @Override
    public BlendedImagesSearch withEndDate(String endDate) {
        map.put(EndDateParameterName, endDate);
        return this;
    }

    @Override
    public BlendedImagesSearch withEventIds(String ids) {
        map.put(EventIdsParameterName, ids);
        return this;
    }

    @Override
    public BlendedImagesSearch withGraphicalStyle(GraphicalStyles graphicalStyle) {
        EnumSet<GraphicalStyles> segments;
        if (map.containsKey(GraphicalStylesString)) {
            segments = (EnumSet<GraphicalStyles>) map.get(GraphicalStylesString);
        } else {
            segments = EnumSet.noneOf(GraphicalStyles.class);
        }
        if (graphicalStyle != GraphicalStyles.NONE) {
            segments.add(graphicalStyle);
        }

        map.put(GraphicalStylesString, segments);
        return this;
    }

    @Override
    public BlendedImagesSearchService withLicenseModel(LicenseModel licenseModel) {
        EnumSet<LicenseModel> licenseModels;

        if (map.containsKey(LicenseModelsParameterName)) {
            licenseModels = (EnumSet<LicenseModel>) map.get(LicenseModelsParameterName);
        } else {
            licenseModels = EnumSet.noneOf(LicenseModel.class);
        }
        if (licenseModel != LicenseModel.NONE) {
            licenseModels.add(licenseModel);
        }
        map.put(LicenseModelsParameterName, licenseModels);
        return this;
    }

    @Override
    public BlendedImagesSearch withPrestigeContentOnly(boolean prestigeContentOnly) {
        map.put(PrestigeContentOnlyParameterName, prestigeContentOnly);
        return this;
    }

    @Override
    public BlendedImagesSearch withSpecificPeople(String people) {
        map.put(SpecificPeopleParameterName, people);
        return this;
    }

    @Override
    public BlendedImagesSearch withStartDate(String startDate) {
        map.put(StartDateParameterName, startDate);
        return this;
    }
}
