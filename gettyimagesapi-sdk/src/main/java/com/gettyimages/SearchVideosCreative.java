package com.gettyimages;

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

    public SearchVideosCreative withAgeOfPeople(AgeOfPeople value)
    {
        addAgeOfPeople(value);
        return this;
    }

    public SearchVideosCreative withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
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

//    public SearchVideosCreative withFormatAvailable(Format value)
//    {
//        addFormatAvailable(value);
//        return this;
//    }
//
//    public SearchVideosCreative withFrameRate(FrameRate value)
//    {
//        addFrameRate(value);
//        return this;
//    }

    public SearchVideosCreative withKeywordIds(Iterable<Integer> values)
    {
        addKeywordIds(values);
        return this;
    }

//    public virtual SearchVideosCreative WithLicenseModel(LicenseModel value)
//    {
//        AddLicenseModel(value);
//        return this;
//    }

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

//    public SearchVideosCreative WithProductType(ProductType value)
//    {
//        AddProductTypes(value);
//        return this;
//    }
//
//    public SearchVideosCreative WithSortOrder(SortOrder value)
//    {
//        AddQueryParameter(Constants.SortOrderKey, value);
//        return this;
//    }
}
