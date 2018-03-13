package com.gettyimages;

import com.gettyimages.Filters.AgeOfPeople;

import java.util.*;

public abstract class AbstractApiRequest<T> {

    protected String baseUrl;
    protected Credentials credentials;
    protected String method;
    protected String path;
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
//            else if (v instanceof EnumSet) {
//                StringBuilder sb = new StringBuilder();
//                boolean first = true;
//                for (var item : v) {
//                    if (first)
//                        first = false;
//                    else
//                        sb.append(",");
//                    sb.append(item);
//                }
//                queryParams.put(k, sb.toString());
//            }
        });

        WebHelper helper = new WebHelper(credentials, baseUrl);
        switch (method)
        {
            case "GET":
                return helper.Get(queryParams, path);
            case "POST":
                return helper.PostQuery(queryParams, path);
//            case "PUT":
//                return helper.Get(queryParams, path);
//            case "DELETE":
//                return helper.Get(queryParams, path);
            default:
                throw new SdkException("No appropriate HTTP method found for this request.");
        }
    }



    public void addAgeOfPeople(AgeOfPeople ageOfPeople) {
        EnumSet<AgeOfPeople> ageOfPeoples;

        if (queryParams.containsKey(Constants.AgeOfPeopleParameterName)) {
            ageOfPeoples = (EnumSet<AgeOfPeople>) queryParams.get(Constants.AgeOfPeopleParameterName);
        } else {
            ageOfPeoples = EnumSet.noneOf(AgeOfPeople.class);
        }
        if (ageOfPeople != AgeOfPeople.NONE) {
            ageOfPeoples.add(ageOfPeople);
        }

        queryParams.put(Constants.AgeOfPeopleParameterName, ageOfPeoples);
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
