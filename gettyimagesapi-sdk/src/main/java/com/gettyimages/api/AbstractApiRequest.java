package com.gettyimages.api;

import com.gettyimages.api.Filters.*;
import org.apache.http.HttpEntity;

import java.util.*;

public abstract class AbstractApiRequest<T> {

    protected String baseUrl;
    protected Credentials credentials;
    protected String method;
    protected String path;
    protected HttpEntity body;
    protected Map<String, Object> queryParams = new HashMap<>();

    public AbstractApiRequest(Credentials credentials, String baseUrl) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
    }

    protected String executeAsync() throws SdkException {

        queryParams.forEach((k, v)->{
            if (v instanceof List<?>) {
                String result = String.join(",", (List<String>) v);
                queryParams.put(k, result);
            }
            else if (v instanceof Integer) {
                queryParams.put(k, String.valueOf(v));
            }
            else if (v instanceof Boolean) {
                queryParams.put(k, String.valueOf(v));
            }
            else if (v instanceof EnumSet) {
                StringBuilder sb = new StringBuilder();
                for (Object item : (EnumSet) v) {
                    sb.append(item);
                    sb.append(",");
                }
                String result = sb.substring(0,sb.length() - 1);
                queryParams.put(k, result);
            }
        });

        WebHelper helper = new WebHelper(credentials, baseUrl);
        switch (method)
        {
            case "GET":
                return helper.Get(queryParams, path);
            case "POST":
                return helper.PostQuery(queryParams, path, body);
            case "PUT":
                return helper.PutQuery(queryParams, path, body);
            case "DELETE":
                return helper.DeleteQuery(queryParams, path);
            default:
                throw new SdkException("No appropriate HTTP method found for this request.");
        }
    }

    public void addAgeOfPeople(EnumSet<AgeOfPeople> ageOfPeople) {
        EnumSet<AgeOfPeople> values;

        if (queryParams.containsKey(Constants.AgeOfPeopleParameterName)) {
            values = (EnumSet<AgeOfPeople>) queryParams.get(Constants.AgeOfPeopleParameterName);
        } else {
            values = EnumSet.noneOf(AgeOfPeople.class);
        }
        for (AgeOfPeople item : ageOfPeople) {
            values.add(item);
        }

        queryParams.put(Constants.AgeOfPeopleParameterName, values);
    }

    public void addArtists(Iterable<String> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.ArtistParameterName)) {
            assets = (List<String>) queryParams.get(Constants.ArtistParameterName);
        } else {
            assets = new ArrayList<>();
        }
        for (String item : values) {
            assets.add(item);
        }

        queryParams.put(Constants.ArtistParameterName, assets);
    }

    public void addCollectionCodes(Iterable<String> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.CollectionCodesParameterName)) {
            assets = (List<String>) queryParams.get(Constants.CollectionCodesParameterName);
        } else {
            assets = new ArrayList<>();
        }
        for (String item : values) {
            assets.add(item);
        }

        queryParams.put(Constants.CollectionCodesParameterName, assets);
    }

    public void addCompositions(EnumSet<Compositions> compositions) {
        EnumSet<Compositions> values;

        if (queryParams.containsKey(Constants.CompositionsParameterName)) {
            values = (EnumSet<Compositions>) queryParams.get(Constants.CompositionsParameterName);
        } else {
            values = EnumSet.noneOf(Compositions.class);
        }
        for (Compositions item : compositions) {
            values.add(item);
        }

        queryParams.put(Constants.CompositionsParameterName, values);
    }

    public void addEditorialSegments(EnumSet<EditorialSegment> editorialSegments) {
        EnumSet<EditorialSegment> values;

        if (queryParams.containsKey(Constants.EditorialSegmentsParameterName)) {
            values = (EnumSet<EditorialSegment>) queryParams.get(Constants.EditorialSegmentsParameterName);
        } else {
            values = EnumSet.noneOf(EditorialSegment.class);
        }
        for (EditorialSegment item : editorialSegments) {
            values.add(item);
        }

        queryParams.put(Constants.EditorialSegmentsParameterName, values);
    }

    public void addEditorialVideoTypes(EnumSet<EditorialVideoType> editorialVideoTypes) {
        EnumSet<EditorialVideoType> values;

        if (queryParams.containsKey(Constants.EditorialVideoTypeParameterName)) {
            values = (EnumSet<EditorialVideoType>) queryParams.get(Constants.EditorialVideoTypeParameterName);
        } else {
            values = EnumSet.noneOf(EditorialVideoType.class);
        }
        for (EditorialVideoType item : editorialVideoTypes) {
            values.add(item);
        }

        queryParams.put(Constants.EditorialVideoTypeParameterName, values);
    }

    public void addEntityUris(Iterable<String> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.EntityUriParameterName)) {
            assets = (List<String>) queryParams.get(Constants.EntityUriParameterName);
        } else {
            assets = new ArrayList<>();
        }
        for (String item : values) {
            String i = String.valueOf(item);
            assets.add(i);
        }

        queryParams.put(Constants.EntityUriParameterName, assets);
    }

    public void addEthnicity(EnumSet<Ethnicity> ethnicity) {
        EnumSet<Ethnicity> values;

        if (queryParams.containsKey(Constants.EthnicityParameterName)) {
            values = (EnumSet<Ethnicity>) queryParams.get(Constants.EthnicityParameterName);
        } else {
            values = EnumSet.noneOf(Ethnicity.class);
        }
        for (Ethnicity item : ethnicity) {
            values.add(item);
        }

        queryParams.put(Constants.EthnicityParameterName, values);
    }

    public void addEventIds(Iterable<Integer> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.EventIdsParameterName)) {
            assets = (List<String>) queryParams.get(Constants.EventIdsParameterName);
        } else {
            assets = new ArrayList<>();
        }
        for (Integer item : values) {
            String i = String.valueOf(item);
            assets.add(i);
        }

        queryParams.put(Constants.EventIdsParameterName, assets);
    }

    public void addResponseFields(Iterable<String> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.FieldsString)) {
            assets = (List<String>) queryParams.get(Constants.FieldsString);
        } else {
            assets = new ArrayList<>();
        }
        for (String item : values) {
                assets.add(item);
        }

        queryParams.put(Constants.FieldsString, assets);
    }

    public void addFileTypes(EnumSet<FileType> fileTypes) {
        EnumSet<FileType> values;

        if (queryParams.containsKey(Constants.FileTypesParameterName)) {
            values = (EnumSet<FileType>) queryParams.get(Constants.FileTypesParameterName);
        } else {
            values = EnumSet.noneOf(FileType.class);
        }
        for (FileType item : fileTypes) {
            values.add(item);
        }

        queryParams.put(Constants.FileTypesParameterName, values);
    }

    public void addFrameRates(EnumSet<FrameRate> frameRates) {
        EnumSet<FrameRate> values;

        if (queryParams.containsKey(Constants.FrameRateParameterName)) {
            values = (EnumSet<FrameRate>) queryParams.get(Constants.FrameRateParameterName);
        } else {
            values = EnumSet.noneOf(FrameRate.class);
        }
        for (FrameRate item : frameRates) {
            values.add(item);
        }

        queryParams.put(Constants.FrameRateParameterName, values);
    }

    public void addGraphicalStyles(EnumSet<GraphicalStyles> graphicalStyles) {
        EnumSet<GraphicalStyles> values;

        if (queryParams.containsKey(Constants.GraphicalStylesString)) {
            values = (EnumSet<GraphicalStyles>) queryParams.get(Constants.GraphicalStylesString);
        } else {
            values = EnumSet.noneOf(GraphicalStyles.class);
        }
        for (GraphicalStyles item : graphicalStyles) {
            values.add(item);
        }

        queryParams.put(Constants.GraphicalStylesString, values);
    }

    public void addKeywordIds(Iterable<Integer> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.KeywordIdsParameterName)) {
            assets = (List<String>) queryParams.get(Constants.KeywordIdsParameterName);
        } else {
            assets = new ArrayList<>();
        }
        for (Integer item : values) {
            String i = String.valueOf(item);
            assets.add(i);
        }

        queryParams.put(Constants.KeywordIdsParameterName, assets);
    }

    public void addLicenseModels(EnumSet<LicenseModel> licenseModels) {
        EnumSet<LicenseModel> values;

        if (queryParams.containsKey(Constants.LicenseModelsParameterName)) {
            values = (EnumSet<LicenseModel>) queryParams.get(Constants.LicenseModelsParameterName);
        } else {
            values = EnumSet.noneOf(LicenseModel.class);
        }
        for (LicenseModel item : licenseModels) {
            values.add(item);
        }

        queryParams.put(Constants.LicenseModelsParameterName, values);
    }

    public void addNumberOfPeople(EnumSet<NumberOfPeople> numberOfPeople) {
        EnumSet<NumberOfPeople> values;

        if (queryParams.containsKey(Constants.NumberOfPeopleParameterName)) {
            values = (EnumSet<NumberOfPeople>) queryParams.get(Constants.NumberOfPeopleParameterName);
        } else {
            values = EnumSet.noneOf(NumberOfPeople.class);
        }
        for (NumberOfPeople item : numberOfPeople) {
            values.add(item);
        }

        queryParams.put(Constants.NumberOfPeopleParameterName, values);
    }

    public void addOrientations(EnumSet<Orientation> orientations) {
        EnumSet<Orientation> values;

        if (queryParams.containsKey(Constants.OrientationsParameterName)) {
            values = (EnumSet<Orientation>) queryParams.get(Constants.OrientationsParameterName);
        } else {
            values = EnumSet.noneOf(Orientation.class);
        }
        for (Orientation item : orientations) {
            values.add(item);
        }

        queryParams.put(Constants.OrientationsParameterName, values);
    }

    public void addProductTypes(EnumSet<ProductType> productTypes) {
        EnumSet<ProductType> values;

        if (queryParams.containsKey(Constants.ProductTypesParameterName)) {
            values = (EnumSet<ProductType>) queryParams.get(Constants.ProductTypesParameterName);
        } else {
            values = EnumSet.noneOf(ProductType.class);
        }
        for (ProductType item : productTypes) {
            values.add(item);
        }

        queryParams.put(Constants.ProductTypesParameterName, values);
    }

    public void addSpecificPeople(Iterable<String> values) {
        List<String> assets;

        if (queryParams.containsKey(Constants.SpecificPeopleParameterName)) {
            assets = (List<String>) queryParams.get(Constants.SpecificPeopleParameterName);
        } else {
            assets = new ArrayList<>();
        }
        for (String item : values) {
            assets.add(item);
        }

        queryParams.put(Constants.SpecificPeopleParameterName, assets);
    }
}
