package com.gettyimages;

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

    public SearchVideos withAgeOfPeople(AgeOfPeople value)
    {
        addAgeOfPeople(value);
        return this;
    }

    public SearchVideos withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

//    public SearchVideos WithEditorialVideoTypes(EditorialVideoType value)
//    {
//        addEditorialVideoType(value);
//        return this;
//    }

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

//    public SearchVideos withFormatAvailable(Format value)
//    {
//        addFormatAvailable(value);
//        return this;
//    }
//
//    public SearchVideos withFrameRate(FrameRate value)
//    {
//        addFrameRate(value);
//        return this;
//    }

    public SearchVideos withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

//    public virtual SearchVideos WithLicenseModel(LicenseModel value)
//    {
//        AddLicenseModel(value);
//        return this;
//    }

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

//    public SearchVideos WithProductType(ProductType value)
//    {
//        AddProductTypes(value);
//        return this;
//    }
//
//    public SearchVideos WithSortOrder(SortOrder value)
//    {
//        AddQueryParameter(Constants.SortOrderKey, value);
//        return this;
//    }

    public SearchVideos withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }
}

