
import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.Search.SearchVideosEditorial;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class SearchVideosEditorialTest {
    private static ClientAndServer mockServer;

    @BeforeAll
    public static void startProxy() throws Exception {
        Field field = ApiClient.class.getDeclaredField("baseUrl");
        field.setAccessible(true);
        field.set(null, "http://127.0.0.1:1080/");
        mockServer = startClientAndServer(1080);
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
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/editorial")
                                .withQueryStringParameters(
                                        new Parameter("age_of_people", "baby,child,adult")
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
                                        new Parameter("collections_filter_type", "exclude")
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

    @Test
    void searchVideosEditorialWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withAcceptLanguage("de");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

   @Test
    void searchVideosEditorialWithAgeOfPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withAgeOfPeople(EnumSet.of(AgeOfPeople.ADULT)).withAgeOfPeople(EnumSet.of(AgeOfPeople.CHILD, AgeOfPeople.BABY));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithCollectionCodes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withCollectionCodes(Arrays.asList("WRI", "ARF"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithCollectionFilter() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withCollectionFilterType(CollectionFilter.EXCLUDE);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithEditorialVideoTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withEditorialVideoTypes(EnumSet.of(EditorialVideoType.RAW, EditorialVideoType.PRODUCED));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithEntityUris() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withEntityUris(Arrays.asList("uri1", "uri2"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithExcludeNudity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withExcludeNudity(true);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithFormatAvailable() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withFormatAvailable(FormatAvailable.HD);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

   @Test
    void searchVideosEditorialWithFrameRates() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withFrameRates(EnumSet.of(FrameRate.FRAMERATE_24, FrameRate.FRAMERATE_29));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithKeywordIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withKeywordIds(Arrays.asList(1111,2222,3333));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithPage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withPage(3);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithPageSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withPageSize(50);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithPhrase() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withPhrase("cat");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithProductTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withProductTypes(EnumSet.of(ProductType.EASYACCESS, ProductType.EDITORIALSUBSCRIPTION));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithSortOrder() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withSortOrder(SortOrder.NEWEST);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosEditorialWithSpecificPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosEditorial search = client.searchvideoseditorial()
                .withSpecificPeople(Arrays.asList("Reggie Jackson"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
