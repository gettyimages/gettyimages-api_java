package com.gettyimages.api.Search;

import com.gettyimages.api.AbstractApiRequest;
import com.gettyimages.api.Constants;
import com.gettyimages.api.Credentials;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.SdkException;

import java.util.EnumSet;

public class SearchImagesCreative extends AbstractApiRequest {

    private SearchImagesCreative(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static SearchImagesCreative GetInstance(Credentials credentials, String baseUrl) {
        return new SearchImagesCreative(credentials, baseUrl);
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/images/creative";

        return super.executeAsync();
    }

    public SearchImagesCreative withAgeOfPeople(EnumSet<AgeOfPeople> values)
    {
        addAgeOfPeople(values);
        return this;
    }

    public SearchImagesCreative withArtists(Iterable<String> values)
    {
        addArtists(values);
        return this;
    }

    public SearchImagesCreative withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

    public SearchImagesCreative withCollectionFilterType(CollectionFilter value)
    {
        queryParams.put(Constants.CollectionsFilterTypeParameterName, value);
        return this;
    }

    public SearchImagesCreative withColor(String value)
    {
        queryParams.put(Constants.ColorParameterName, value);
        return this;
    }

    public SearchImagesCreative withCompositions(EnumSet<Compositions> values)
    {
        addCompositions(values);
        return this;
    }

    public SearchImagesCreative withEmbedContentOnly(Boolean value)
    {
        queryParams.put(Constants.EmbedContentOnlyParameterName, value);
        return this;
    }

    public SearchImagesCreative withEthnicity(EnumSet<Ethnicity> values)
    {
        addEthnicity(values);
        return this;
    }

    public SearchImagesCreative withExcludeNudity(Boolean value)
    {
        queryParams.put(Constants.ExcludeNudityParameterName, value);
        return this;
    }

    public SearchImagesCreative withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }

    public SearchImagesCreative withFileTypes(EnumSet<FileType> values)
    {
        addFileTypes(values);
        return this;
    }

    public SearchImagesCreative withGraphicalStyles(EnumSet<GraphicalStyles> values)
    {
        addGraphicalStyles(values);
        return this;
    }

    public SearchImagesCreative withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

    public SearchImagesCreative withLicenseModels(EnumSet<LicenseModel> values)
    {
        addLicenseModels(values);
        return this;
    }

    public SearchImagesCreative withMinimumSize(MinimumSize value)
    {
        queryParams.put(Constants.MinimumSizeParameterName, value);
        return this;
    }

    public SearchImagesCreative withNumberOfPeople(EnumSet<NumberOfPeople> values)
    {
        addNumberOfPeople(values);
        return this;
    }

    public SearchImagesCreative withOrientations(EnumSet<Orientation> values)
    {
        addOrientations(values);
        return this;
    }

    public SearchImagesCreative withPage(Integer value)
    {
        queryParams.put(Constants.PageParameterName, value);
        return this;
    }

    public SearchImagesCreative withPageSize(Integer value)
    {
        queryParams.put(Constants.PageSizeString, value);
        return this;
    }

    public SearchImagesCreative withPhrase(String value)
    {
        queryParams.put(Constants.PhraseParameterName, value);
        return this;
    }

    public SearchImagesCreative withPrestigeContentOnly(Boolean value)
    {
        queryParams.put(Constants.PrestigeContentOnlyParameterName, value);
        return this;
    }

    public SearchImagesCreative withProductTypes(EnumSet<ProductType> values)
    {
        addProductTypes(values);
        return this;
    }

    public SearchImagesCreative withSortOrder(SortOrder value)
    {
        queryParams.put(Constants.SortOrderParameterName, value);
        return this;
    }
}
