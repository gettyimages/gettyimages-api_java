package com.gettyimages;

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

    public SearchVideosEditorial withAgeOfPeople(AgeOfPeople value)
    {
        addAgeOfPeople(value);
        return this;
    }

    public SearchVideosEditorial withCollectionCodes(Iterable<String> values)
    {
        addCollectionCodes(values);
        return this;
    }

//    public SearchVideosEditorial WithEditorialVideoTypes(EditorialVideoType value)
//    {
//        addEditorialVideoType(value);
//        return this;
//    }

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

//    public SearchVideosEditorial withFormatAvailable(Format value)
//    {
//        addFormatAvailable(value);
//        return this;
//    }
//
//    public SearchVideosEditorial withFrameRate(FrameRate value)
//    {
//        addFrameRate(value);
//        return this;
//    }

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

//    public SearchVideosEditorial WithProductType(ProductType value)
//    {
//        AddProductTypes(value);
//        return this;
//    }
//
//    public SearchVideosEditorial WithSortOrder(SortOrder value)
//    {
//        AddQueryParameter(Constants.SortOrderKey, value);
//        return this;
//    }

    public SearchVideosEditorial withSpecificPeople(Iterable<String> values)
    {
        addSpecificPeople(values);
        return this;
    }
}
