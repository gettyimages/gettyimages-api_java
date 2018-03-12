package com.gettyimages;

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

    public SearchImages withAgeOfPeople(AgeOfPeople value)
    {
        addAgeOfPeople(value);
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

//    public SearchImages withCollectionFilterType(CollectionFilter value)
//    {
//        AddQueryParameter(Constants.CollectionFilterKey, value);
//        return this;
//    }

    public SearchImages withColor(String value)
    {
        queryParams.put(Constants.ColorParameterName, value);
        return this;
    }

//    public SearchImages WithComposition(Composition value)
//    {
//        AddComposition(value);
//        return this;
//    }

    public SearchImages withEmbedContentOnly(Boolean value)
    {
        queryParams.put(Constants.EmbedContentOnlyParameterName, value);
        return this;
    }

//    public SearchImages WithEthnicity(Ethnicity value)
//    {
//        AddEthnicity(value);
//        return this;
//    }

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

//    public SearchImages WithFileType(FileType value)
//    {
//        AddFileTypes(value);
//        return this;
//    }
//
//    public SearchImages WithGraphicalStyle(GraphicalStyles value)
//    {
//        AddGraphicalStyle(value);
//        return this;
//    }

    public SearchImages withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

//    public virtual SearchImages WithLicenseModel(LicenseModel value)
//    {
//        AddLicenseModel(value);
//        return this;
//    }
//
//    public SearchImages WithMinimumSize(MinimumSize value)
//    {
//        AddQueryParameter(Constants.MinimumSizeKey, value);
//        return this;
//    }
//
//    public SearchImages WithNumberOfPeople(NumberOfPeople value)
//    {
//        AddNumberOfPeople(value);
//        return this;
//    }
//
//    public SearchImages WithOrientation(Orientation value)
//    {
//        AddOrientation(value);
//        return this;
//    }

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

//    public SearchImages WithProductType(ProductType value)
//    {
//        AddProductTypes(value);
//        return this;
//    }
//
//    public SearchImages WithSortOrder(SortOrder value)
//    {
//        AddQueryParameter(Constants.SortOrderKey, value);
//        return this;
//    }

    public SearchImages withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }
}
