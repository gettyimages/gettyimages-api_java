package com.gettyimages.api.Search;

import com.gettyimages.api.AbstractApiRequest;
import com.gettyimages.api.Constants;
import com.gettyimages.api.Credentials;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.SdkException;

import java.util.EnumSet;

public class SearchVideosCreative extends AbstractApiRequest {

    private SearchVideosCreative(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static SearchVideosCreative GetInstance(Credentials credentials, String baseUrl) {
        return new SearchVideosCreative(credentials, baseUrl);
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/videos/creative";

        return super.executeAsync();
    }

    public SearchVideosCreative withAgeOfPeople(EnumSet<AgeOfPeople> values)
    {
        addAgeOfPeople(values);
        return this;
    }

    public SearchVideosCreative withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

    public SearchVideosCreative withCollectionFilterType(CollectionFilter value)
    {
        queryParams.put(Constants.CollectionsFilterTypeParameterName, value);
        return this;
    }

    public SearchVideosCreative withExcludeNudity(Boolean value)
    {
        queryParams.put(Constants.ExcludeNudityParameterName, value);
        return this;
    }

    public SearchVideosCreative withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }

    public SearchVideosCreative withFormatAvailable(FormatAvailable value)
    {
        queryParams.put(Constants.FormatAvailableParameterName, value);
        return this;
    }

    public SearchVideosCreative withFrameRates(EnumSet<FrameRate> values)
    {
        addFrameRates(values);
        return this;
    }

    public SearchVideosCreative withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

    public SearchVideosCreative withLicenseModels(EnumSet<LicenseModel> values)
    {
        addLicenseModels(values);
        return this;
    }

    public SearchVideosCreative withPage(Integer value)
    {
        queryParams.put(Constants.PageParameterName, value);
        return this;
    }

    public SearchVideosCreative withPageSize(Integer value)
    {
        queryParams.put(Constants.PageSizeString, value);
        return this;
    }

    public SearchVideosCreative withPhrase(String value)
    {
        queryParams.put(Constants.PhraseParameterName, value);
        return this;
    }

    public SearchVideosCreative withProductTypes(EnumSet<ProductType> values)
    {
        addProductTypes(values);
        return this;
    }

    public SearchVideosCreative withSortOrder(SortOrder value)
    {
        queryParams.put(Constants.SortOrderParameterName, value);
        return this;
    }
}
