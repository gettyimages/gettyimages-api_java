package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class CreativeImagesSearchService extends AbstractImagesSearch implements CreativeImagesSearch<CreativeImagesSearchService>{

    public CreativeImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
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
        setBooleanQueryParameter(PrestigeContentOnlyParameterName, queryParams);
        return this.executeAsync(queryParams);
    }

    @Override
    public CreativeImagesSearchService withGraphicalStyle(GraphicalStyles graphicalStyle) {
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
    public CreativeImagesSearchService withLicenseModel(LicenseModel licenseModel) {
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
    public CreativeImagesSearchService withPrestigeContentOnly(boolean prestigeContentOnly) {
        map.put(PrestigeContentOnlyParameterName, prestigeContentOnly);
        return this;
    }
}
