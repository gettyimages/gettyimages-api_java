package com.gettyimages.connectconsoleapp;

import com.gettyimages.connectsdk.ConnectSdk;
import com.gettyimages.connectsdk.SdkException;
import com.gettyimages.connectsdk.search.ICreativeImagesSearch;
import com.gettyimages.connectsdk.search.Search;

public class Main {
    private static String apiKey = "Getty API Key";
    private static String apiSecret = "Getty API Secret";
    private static String userName = "";
    private static String userPassword = "";

    public static void main(String[] args) {

        ConnectSdk connectSdk = new ConnectSdk(apiKey, apiSecret);
        String searchTerm = "cat";
        String result = "";
        try {
            Search search = connectSdk.Search();
            ICreativeImagesSearch creativeImageSearch = search.Images().Creative().WithPhrase(searchTerm).WithPage(10);
            result = creativeImageSearch.ExecuteAsync();
        } catch (SdkException e) {
            result = e.getMessage();
        }
        catch (Exception e) {
            result = e.toString();
        }
        
        System.out.print(result);
    }
}
