package com.gettyimages.api.Search;

import com.gettyimages.api.AbstractApiRequest;
import com.gettyimages.api.Constants;
import com.gettyimages.api.Credentials;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.SdkException;

import java.util.EnumSet;

public class SearchImages extends AbstractApiRequest {

    private SearchImages(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static SearchImages GetInstance(Credentials credentials, String baseUrl) {
        return new SearchImages(credentials, baseUrl);
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/images";

        return super.executeAsync();
    }

    public SearchImages withAcceptLanguage(String value)
    {
        headers.put(Constants.AcceptLanguageString, value);
        return this;
    }

    public SearchImages withAgeOfPeople(EnumSet<AgeOfPeople> values)
    {
        addAgeOfPeople(values);
        return this;
    }

    public SearchImages withArtists(Iterable<String> values)
    {
        addArtists(values);
        return this;
    }

    public SearchImages withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

    public SearchImages withCollectionFilterType(CollectionFilter value)
    {
        queryParams.put(Constants.CollectionsFilterTypeParameterName, value);
        return this;
    }

    public SearchImages withColor(String value)
    {
        queryParams.put(Constants.ColorParameterName, value);
        return this;
    }

    public SearchImages withCompositions(EnumSet<Compositions> values)
    {
        addCompositions(values);
        return this;
    }

    public SearchImages withEmbedContentOnly(Boolean value)
    {
        queryParams.put(Constants.EmbedContentOnlyParameterName, value);
        return this;
    }

    public SearchImages withEthnicity(EnumSet<Ethnicity> values)
    {
        addEthnicity(values);
        return this;
    }

    public SearchImages withEventIds(Iterable<Integer> values)
    {
        addEventIds(values);
        return this;
    }

    public SearchImages withExcludeNudity(Boolean value)
    {
        queryParams.put(Constants.ExcludeNudityParameterName, value);
        return this;
    }

    public SearchImages withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }

    public SearchImages withFileTypes(EnumSet<FileType> values)
    {
        addFileTypes(values);
        return this;
    }

    public SearchImages withGraphicalStyles(EnumSet<GraphicalStyles> values)
    {
        addGraphicalStyles(values);
        return this;
    }

    public SearchImages withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

    public SearchImages withLicenseModels(EnumSet<LicenseModel> values)
    {
        addLicenseModels(values);
        return this;
    }

    public SearchImages withMinimumSize(MinimumSize value)
    {
        queryParams.put(Constants.MinimumSizeParameterName, value);
        return this;
    }

    public SearchImages withNumberOfPeople(EnumSet<NumberOfPeople> values)
    {
        addNumberOfPeople(values);
        return this;
    }

    public SearchImages withOrientations(EnumSet<Orientation> values)
    {
        addOrientations(values);
        return this;
    }

    public SearchImages withPage(Integer value)
    {
        queryParams.put(Constants.PageParameterName, value);
        return this;
    }

    public SearchImages withPageSize(Integer value)
    {
        queryParams.put(Constants.PageSizeString, value);
        return this;
    }

    public SearchImages withPhrase(String value)
    {
        queryParams.put(Constants.PhraseParameterName, value);
        return this;
    }

    public SearchImages withPrestigeContentOnly(Boolean value)
    {
        queryParams.put(Constants.PrestigeContentOnlyParameterName, value);
        return this;
    }

    public SearchImages withProductTypes(EnumSet<ProductType> values)
    {
        addProductTypes(values);
        return this;
    }

    public SearchImages withSortOrder(com.gettyimages.api.Filters.SortOrder value)
    {
        queryParams.put(Constants.SortOrderParameterName, value);
        return this;
    }

    public SearchImages withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }
}
