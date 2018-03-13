package unittests.Search;

import com.gettyimages.ApiClient;
import com.gettyimages.Search.SearchVideosCreative;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class SearchVideosCreativeTests {
    private static ClientAndServer mockServer;

    @BeforeAll
    public static void startProxy() throws Exception {
        Field field = ApiClient.class.getDeclaredField("baseUrl");
        field.setAccessible(true);
        field.set(null, "http://127.0.0.1:1080/");
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
//    void searchVideosCreativeWithAgeOfPeople() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withAgeOfPeople(AgeOfPeople.ADULT);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchVideosCreativeWithCollectionCodes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withCollectionCodes(Arrays.asList("WRI", "ARF"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }
//
//    @Test
//    void searchVideosCreativeWithCollectionFilter() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withCollectionFilter(CollectionFilter.EXCLUDE);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchVideosCreativeWithExcludeNudity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withExcludeNudity(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchVideosCreativeWithFormatAvailable() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withFormatAvailable(Format.HD);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }
//
//   @Test
//    void searchVideosCreativeWithFrameRates() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withFrameRates(FrameRate.FRAMERATE24 | FrameRate.FRAMERATE29);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchVideosCreativeWithKeywordIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withKeywordIds(Arrays.asList(1111,2222,3333));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchVideosCreativeWithLicenseModels() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withLicenseModels(LicenseModel.RIGHTS_MANAGED);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchVideosCreativeWithPage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withPage(3);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithPageSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withPageSize(50);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithPhrase() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withPhrase("cat");
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchVideosCreativeWithProductTypes() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withProductTypes(ProductType.EASYACCESS | ProductType.EDITORIALSUBSCRIPTION);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

//    @Test
//    void searchVideosCreativeWithSortOrder() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchVideosCreative search = client.searchvideoscreative()
//                .withSortOrder(SortOrder.NEWEST);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
