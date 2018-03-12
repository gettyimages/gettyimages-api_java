package unittests;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;
import com.gettyimages.SearchVideosEditorial;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class SearchVideosEditorialTests {
    private static ClientAndServer mockServer;

    @BeforeAll
    public static void startProxy() {
        mockServer = startClientAndServer(1080);
    }

    @BeforeEach
    public void createMock(){
        MockServerClient client = new MockServerClient("127.0.0.1", 1080);

        client
                .when(request()
                        .withMethod("POST")
                        .withPath("/oauth2/token")
                )
                .respond(response()
                        .withStatusCode(200)
                        .withBody("{ access_token: 'client_credentials_access_token', token_type: 'Bearer', expires_in: '1800' }")
                );
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("age_of_people", "adult")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("collection_codes", "WRI,ARF")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("collection_filter_type", "exclude")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("editorial_video_types", "raw,produced")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("entity_uris", "uri1,uri2")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("exclude_nudity", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("fields", "asset_family,id,uri_oembed")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("format_available", "hd")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("frame_rates", "24,29.97")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("keyword_ids", "1111,2222,3333")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("page", "3")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("page_size", "50")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("phrase", "cat")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("product_types", "easyaccess,editorialsubscription")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("sort_order", "newest")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/editorial")
                        .withQueryStringParameters(
                                new Parameter("specific_people", "Reggie Jackson")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
    }

//   @Test
//    void searchVideosEditorialWithAgeOfPeople() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withAgeOfPeople(AgeOfPeople.ADULT);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchVideosEditorialWithCollectionCodes() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withCollectionCodes(Arrays.asList("WRI", "ARF"));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }
//
//    @Test
//    void searchVideosEditorialWithCollectionFilter() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withCollectionFilter(CollectionFilter.EXCLUDE);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

//    @Test
//    void searchVideosEditorialWithEditorialVideoTypes() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withEditorialVideoTypes(EditorialVideoType.RAW | EditorialVideoType.PRODUCED);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchVideosEditorialWithEntityUris() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withEntityUris(Arrays.asList("uri1", "uri2"));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchVideosEditorialWithExcludeNudity() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withExcludeNudity(true);
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchVideosEditorialWithResponseFields() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

//    @Test
//    void searchVideosEditorialWithFormatAvailable() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withFormatAvailable(Format.HD);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }
//
//   @Test
//    void searchVideosEditorialWithFrameRates() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withFrameRates(FrameRate.FRAMERATE24 | FrameRate.FRAMERATE29);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchVideosEditorialWithKeywordIds() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withKeywordIds(Arrays.asList(1111,2222,3333));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchVideosEditorialWithPage() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withPage(3);
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchVideosEditorialWithPageSize() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withPageSize(50);
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchVideosEditorialWithPhrase() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withPhrase("cat");
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

//    @Test
//    void searchVideosEditorialWithProductTypes() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withProductTypes(ProductType.EASYACCESS | ProductType.EDITORIALSUBSCRIPTION);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

//    @Test
//    void searchVideosEditorialWithSortOrder() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosEditorial search = client.searchvideoseditorial()
//                    .withSortOrder(SortOrder.NEWEST);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchVideosEditorialWithSpecificPeople() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosEditorial search = client.searchvideoseditorial()
                    .withSpecificPeople(Arrays.asList("Reggie Jackson"));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
