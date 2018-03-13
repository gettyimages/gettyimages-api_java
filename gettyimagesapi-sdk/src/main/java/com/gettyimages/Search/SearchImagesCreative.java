package com.gettyimages.Search;

import com.gettyimages.*;
import com.gettyimages.Filters.AgeOfPeople;

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

    public SearchImagesCreative withAgeOfPeople(AgeOfPeople value)
    {
        addAgeOfPeople(value);
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

//    public SearchImagesCreative withCollectionFilterType(CollectionFilter value)
//    {
//        AddQueryParameter(Constants.CollectionFilterKey, value);
//        return this;
//    }

    public SearchImagesCreative withColor(String value)
    {
        queryParams.put(Constants.ColorParameterName, value);
        return this;
    }

//    public SearchImagesCreative WithComposition(Composition value)
//    {
//        AddComposition(value);
//        return this;
//    }

    public SearchImagesCreative withEmbedContentOnly(Boolean value)
    {
        queryParams.put(Constants.EmbedContentOnlyParameterName, value);
        return this;
    }

//    public SearchImagesCreative WithEthnicity(Ethnicity value)
//    {
//        AddEthnicity(value);
//        return this;
//    }

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

//    public SearchImagesCreative WithFileType(FileType value)
//    {
//        AddFileTypes(value);
//        return this;
//    }
//
//    public SearchImagesCreative WithGraphicalStyle(GraphicalStyles value)
//    {
//        AddGraphicalStyle(value);
//        return this;
//    }

    public SearchImagesCreative withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

//    public virtual SearchImagesCreative WithLicenseModel(LicenseModel value)
//    {
//        AddLicenseModel(value);
//        return this;
//    }
//
//    public SearchImagesCreative WithMinimumSize(MinimumSize value)
//    {
//        AddQueryParameter(Constants.MinimumSizeKey, value);
//        return this;
//    }
//
//    public SearchImagesCreative WithNumberOfPeople(NumberOfPeople value)
//    {
//        AddNumberOfPeople(value);
//        return this;
//    }
//
//    public SearchImagesCreative WithOrientation(Orientation value)
//    {
//        AddOrientation(value);
//        return this;
//    }

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

//    public SearchImagesCreative WithProductType(ProductType value)
//    {
//        AddProductTypes(value);
//        return this;
//    }
//
//    public SearchImagesCreative WithSortOrder(SortOrder value)
//    {
//        AddQueryParameter(Constants.SortOrderKey, value);
//        return this;
//    }
}
