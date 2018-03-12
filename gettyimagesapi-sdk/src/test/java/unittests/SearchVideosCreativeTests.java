package unittests;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;
import com.gettyimages.SearchVideosCreative;
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

public class SearchVideosCreativeTests {
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
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("age_of_people", "adult")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("collection_codes", "WRI,ARF")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("collection_filter_type", "exclude")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("exclude_nudity", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("fields", "asset_family,id,uri_oembed")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("format_available", "hd")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("frame_rates", "24,29.97")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("keyword_ids", "1111,2222,3333")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("license_models", "rightsmanaged")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("page", "3")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("page_size", "50")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("phrase", "cat")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("product_types", "easyaccess,editorialsubscription")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/videos/creative")
                        .withQueryStringParameters(
                                new Parameter("sort_order", "newest")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
    }

//   @Test
//    void searchVideosCreativeWithAgeOfPeople() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
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
    void searchVideosCreativeWithCollectionCodes() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
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
//    void searchVideosCreativeWithCollectionFilter() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
//                    .withCollectionFilter(CollectionFilter.EXCLUDE);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchVideosCreativeWithExcludeNudity() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
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
    void searchVideosCreativeWithResponseFields() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
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
//    void searchVideosCreativeWithFormatAvailable() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
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
//    void searchVideosCreativeWithFrameRates() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
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
    void searchVideosCreativeWithKeywordIds() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
                    .withKeywordIds(Arrays.asList(1111,2222,3333));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

//    @Test
//    void searchVideosCreativeWithLicenseModels() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
//                    .withLicenseModels(LicenseModel.RIGHTS_MANAGED);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchVideosCreativeWithPage() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
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
    void searchVideosCreativeWithPageSize() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
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
    void searchVideosCreativeWithPhrase() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchVideosCreative search = client.searchvideoscreative()
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
//    void searchVideosCreativeWithProductTypes() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
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
//    void searchVideosCreativeWithSortOrder() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchVideosCreative search = client.searchvideoscreative()
//                    .withSortOrder(SortOrder.NEWEST);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
