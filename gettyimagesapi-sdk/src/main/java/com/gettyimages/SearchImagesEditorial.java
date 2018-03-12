package com.gettyimages;

import com.gettyimages.search.filters.EditorialSegment;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.Hashtable;
import java.util.Map;

public class SearchImagesEditorial extends AbstractApiRequest {

    private SearchImagesEditorial(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    public static SearchImagesEditorial GetInstance(Credentials credentials, String baseUrl) {
        return new SearchImagesEditorial(credentials, baseUrl, new Hashtable());
    }


    public String executeAsync() throws SdkException {
        method = "GET";
        path = "/search/images/editorial";

        return super.executeAsync();
    }

    public SearchImagesEditorial withAgeOfPeople(AgeOfPeople value)
    {
        addAgeOfPeople(value);
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

//    public SearchImagesEditorial withCollectionFilterType(CollectionFilter value)
//    {
//        AddQueryParameter(Constants.CollectionFilterKey, value);
//        return this;
//    }

//    public SearchImagesEditorial WithComposition(Composition value)
//    {
//        AddComposition(value);
//        return this;
//    }

//    public SearchImagesEditorial withEditorialSegments(EditorialSegment value) {
//        addEditorialSegments(value);
//        return this;
//    }

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

//    public SearchImagesEditorial WithEthnicity(Ethnicity value)
//    {
//        AddEthnicity(value);
//        return this;
//    }

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

//    public SearchImagesEditorial WithFileType(FileType value)
//    {
//        AddFileTypes(value);
//        return this;
//    }
//
//    public SearchImagesEditorial WithGraphicalStyle(GraphicalStyles value)
//    {
//        AddGraphicalStyle(value);
//        return this;
//    }

    public SearchImagesEditorial withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

//    public SearchImagesEditorial withMinimumQualityRank(MinimumQualityRank value) {
//        addMinimumQualityRank(value);
//        return this;
//    }
//
//    public SearchImagesEditorial WithMinimumSize(MinimumSize value)
//    {
//        AddQueryParameter(Constants.MinimumSizeKey, value);
//        return this;
//    }
//
//    public SearchImagesEditorial WithNumberOfPeople(NumberOfPeople value)
//    {
//        AddNumberOfPeople(value);
//        return this;
//    }
//
//    public SearchImagesEditorial WithOrientation(Orientation value)
//    {
//        AddOrientation(value);
//        return this;
//    }

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

//    public SearchImagesEditorial WithProductType(ProductType value)
//    {
//        AddProductTypes(value);
//        return this;
//    }
//
//    public SearchImagesEditorial WithSortOrder(SortOrder value)
//    {
//        AddQueryParameter(Constants.SortOrderKey, value);
//        return this;
//    }

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

