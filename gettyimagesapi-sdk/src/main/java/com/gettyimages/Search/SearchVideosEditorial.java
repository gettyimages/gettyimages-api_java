package com.gettyimages.Search;

import com.gettyimages.*;
import com.gettyimages.Filters.*;

import java.util.EnumSet;

public class SearchVideosEditorial extends AbstractApiRequest {

    private SearchVideosEditorial(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static SearchVideosEditorial GetInstance(Credentials credentials, String baseUrl) {
        return new SearchVideosEditorial(credentials, baseUrl);
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/videos/editorial";

        return super.executeAsync();
    }

    public SearchVideosEditorial withAgeOfPeople(EnumSet<AgeOfPeople> values)
    {
        addAgeOfPeople(values);
        return this;
    }

    public SearchVideosEditorial withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

    public SearchVideosEditorial withCollectionFilterType(CollectionFilter value)
    {
        queryParams.put(Constants.CollectionsFilterTypeParameterName, value);
        return this;
    }

    public SearchVideosEditorial withEditorialVideoTypes(EnumSet<EditorialVideoType> values)
    {
        addEditorialVideoTypes(values);
        return this;
    }

    public SearchVideosEditorial withEntityUris(Iterable<String> values)
    {
        addEntityUris(values);
        return this;
    }

    public SearchVideosEditorial withExcludeNudity(Boolean value)
    {
        queryParams.put(Constants.ExcludeNudityParameterName, value);
        return this;
    }

    public SearchVideosEditorial withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }

    public SearchVideosEditorial withFormatAvailable(FormatAvailable value)
    {
        queryParams.put(Constants.FormatAvailableParameterName, value);
        return this;
    }

    public SearchVideosEditorial withFrameRates(EnumSet<FrameRate> values)
    {
        addFrameRates(values);
        return this;
    }

    public SearchVideosEditorial withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

    public SearchVideosEditorial withPage(Integer value)
    {
        queryParams.put(Constants.PageParameterName, value);
        return this;
    }

    public SearchVideosEditorial withPageSize(Integer value)
    {
        queryParams.put(Constants.PageSizeString, value);
        return this;
    }

    public SearchVideosEditorial withPhrase(String value)
    {
        queryParams.put(Constants.PhraseParameterName, value);
        return this;
    }

    public SearchVideosEditorial withProductTypes(EnumSet<ProductType> values)
    {
        addProductTypes(values);
        return this;
    }

    public SearchVideosEditorial withSortOrder(SortOrder value)
    {
        queryParams.put(Constants.SortOrderParameterName, value);
        return this;
    }

    public SearchVideosEditorial withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }
}
