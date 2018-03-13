package com.gettyimages.Search;

import com.gettyimages.*;
import com.gettyimages.Filters.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.EnumSet;

public class SearchImagesEditorial extends AbstractApiRequest {

    private SearchImagesEditorial(Credentials credentials, String baseUrl) {
        super(credentials, baseUrl);
    }

    public static SearchImagesEditorial GetInstance(Credentials credentials, String baseUrl) {
        return new SearchImagesEditorial(credentials, baseUrl);
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/images/editorial";

        return super.executeAsync();
    }

    public SearchImagesEditorial withAgeOfPeople(EnumSet<AgeOfPeople> values)
    {
        addAgeOfPeople(values);
        return this;
    }

    public SearchImagesEditorial withArtists(Iterable<String> values)
    {
        addArtists(values);
        return this;
    }

    public SearchImagesEditorial withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

    public SearchImagesEditorial withCollectionFilterType(CollectionFilter value)
    {
        queryParams.put(Constants.CollectionsFilterTypeParameterName, value);
        return this;
    }

    public SearchImagesEditorial withCompositions(EnumSet<Compositions> values)
    {
        addCompositions(values);
        return this;
    }

    public SearchImagesEditorial withEditorialSegments(EnumSet<EditorialSegment> values) {
        addEditorialSegments(values);
        return this;
    }

    public SearchImagesEditorial withEmbedContentOnly(Boolean value)
    {
        queryParams.put(Constants.EmbedContentOnlyParameterName, value);
        return this;
    }

    public SearchImagesEditorial withEndDate(String value) {
        queryParams.put(Constants.EndDateParameterName, value);
        return this;
    }

    public SearchImagesEditorial withEntityUris(Iterable<String> values) {
        addEntityUris(values);
        return this;
    }

    public SearchImagesEditorial withEthnicity(EnumSet<Ethnicity> values)
    {
        addEthnicity(values);
        return this;
    }

    public SearchImagesEditorial withEventIds(Iterable<Integer> values)
    {
        addEventIds(values);
        return this;
    }

    public SearchImagesEditorial withExcludeNudity(Boolean value)
    {
        queryParams.put(Constants.ExcludeNudityParameterName, value);
        return this;
    }

    public SearchImagesEditorial withResponseFields(Iterable<String> values)
    {
        addResponseFields(values);
        return this;
    }

    public SearchImagesEditorial withFileTypes(EnumSet<FileType> values)
    {
        addFileTypes(values);
        return this;
    }

    public SearchImagesEditorial withGraphicalStyles(EnumSet<GraphicalStyles> values)
    {
        addGraphicalStyles(values);
        return this;
    }

    public SearchImagesEditorial withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

    public SearchImagesEditorial withMinimumQualityRank(MinimumQualityRank value) {
        queryParams.put(Constants.MinimumQualityRankParameterName, value);
        return this;
    }

    public SearchImagesEditorial withMinimumSize(MinimumSize value)
    {
        queryParams.put(Constants.MinimumSizeParameterName, value);
        return this;
    }

    public SearchImagesEditorial withNumberOfPeople(EnumSet<NumberOfPeople> values)
    {
        addNumberOfPeople(values);
        return this;
    }

    public SearchImagesEditorial withOrientations(EnumSet<Orientation> values)
    {
        addOrientations(values);
        return this;
    }

    public SearchImagesEditorial withPage(Integer value)
    {
        queryParams.put(Constants.PageParameterName, value);
        return this;
    }

    public SearchImagesEditorial withPageSize(Integer value)
    {
        queryParams.put(Constants.PageSizeString, value);
        return this;
    }

    public SearchImagesEditorial withPhrase(String value)
    {
        queryParams.put(Constants.PhraseParameterName, value);
        return this;
    }

    public SearchImagesEditorial withProductTypes(EnumSet<ProductType> values)
    {
        addProductTypes(values);
        return this;
    }

    public SearchImagesEditorial withSortOrder(SortOrder value)
    {
        queryParams.put(Constants.SortOrderParameterName, value);
        return this;
    }

    public SearchImagesEditorial withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }

    public SearchImagesEditorial withStartDate(String value) {
        queryParams.put(Constants.StartDateParameterName, value);
        return this;
    }
}

