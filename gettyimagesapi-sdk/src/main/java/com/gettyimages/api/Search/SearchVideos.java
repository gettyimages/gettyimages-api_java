package com.gettyimages.api.Search;

import com.gettyimages.api.AbstractApiRequest;
import com.gettyimages.api.Constants;
import com.gettyimages.api.Credentials;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.SdkException;

import java.util.EnumSet;

public class SearchVideos extends AbstractApiRequest {

    private SearchVideos(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static SearchVideos GetInstance(Credentials credentials, String baseUrl) {
        return new SearchVideos(credentials, baseUrl);
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/videos";

        return super.executeAsync();
    }

    public SearchVideos withAgeOfPeople(EnumSet<AgeOfPeople> values)
    {
        addAgeOfPeople(values);
        return this;
    }

    public SearchVideos withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

    public SearchVideos withCollectionFilterType(CollectionFilter value)
    {
        queryParams.put(Constants.CollectionsFilterTypeParameterName, value);
        return this;
    }

    public SearchVideos withEditorialVideoTypes(EnumSet<EditorialVideoType> values)
    {
        addEditorialVideoTypes(values);
        return this;
    }

    public SearchVideos withExcludeNudity(Boolean value)
    {
        queryParams.put(Constants.ExcludeNudityParameterName, value);
        return this;
    }

    public SearchVideos withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }

    public SearchVideos withFormatAvailable(FormatAvailable value)
    {
        queryParams.put(Constants.FormatAvailableParameterName, value);
        return this;
    }

    public SearchVideos withFrameRates(EnumSet<FrameRate> values)
    {
        addFrameRates(values);
        return this;
    }

    public SearchVideos withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

    public SearchVideos withLicenseModels(EnumSet<LicenseModel> values)
    {
        addLicenseModels(values);
        return this;
    }

    public SearchVideos withPage(Integer value)
    {
        queryParams.put(Constants.PageParameterName, value);
        return this;
    }

    public SearchVideos withPageSize(Integer value)
    {
        queryParams.put(Constants.PageSizeString, value);
        return this;
    }

    public SearchVideos withPhrase(String value)
    {
        queryParams.put(Constants.PhraseParameterName, value);
        return this;
    }

    public SearchVideos withProductTypes(EnumSet<ProductType> values)
    {
        addProductTypes(values);
        return this;
    }

    public SearchVideos withSortOrder(SortOrder value)
    {
        queryParams.put(Constants.SortOrderParameterName, value);
        return this;
    }

    public SearchVideos withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }
}

