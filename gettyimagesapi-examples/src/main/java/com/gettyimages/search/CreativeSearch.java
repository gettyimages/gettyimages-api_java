package com.gettyimages.search;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;

public class CreativeSearch
{
    private static String apiKey = "API Key";
    private static String apiSecret = "API Secret";
    private static String userName = "";
    private static String userPassword = "";

    public static void main( String[] args )
    {
        ApiClient connectSdk = ApiClient.GetApiClientWithResourceOwnerCredentials(apiKey, apiSecret, userName, userPassword);
        String searchTerm = "cat";

        try {
            Search search = connectSdk.Search();
            ICreativeImagesSearch creativeImageSearch =
                    search.Images()
                            .Creative()
                            .WithPhrase(searchTerm)
                            .WithPage(10);
            String result = creativeImageSearch.ExecuteAsync();
            System.out.print(result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }
}
