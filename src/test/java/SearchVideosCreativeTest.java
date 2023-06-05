
import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.Search.SearchVideosCreative;
import org.junit.jupiter.api.*;
import org.mockserver.model.Parameter;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchVideosCreativeTest extends TestBase {
    @BeforeAll
    public void startProxy() throws Exception {
        startMockServersAndSetupAuth();

        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("age_of_people", "baby,child,adult")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("collection_codes", "WRI,ARF")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("collections_filter_type", "exclude")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("exclude_nudity", "true")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("fields", "asset_family,id,uri_oembed")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("format_available", "hd")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("frame_rates", "24,29.97")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("keyword_ids", "1111,2222,3333")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("license_models", "rightsmanaged")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("page", "3")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("page_size", "50")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("phrase", "cat")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("product_types", "easyaccess,editorialsubscription")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("sort_order", "newest")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withQueryStringParameters(
                                        new Parameter("safe_search", "true")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/videos/creative")
                                .withHeader("gi-country-code", "CAN")
                )
                .respond(response().withStatusCode(200).withBody("success"));
    }

    @Test
    void searchVideosCreativeWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withAcceptLanguage("de");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

   @Test
    void searchVideosCreativeWithAgeOfPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withAgeOfPeople(EnumSet.of(AgeOfPeople.ADULT)).withAgeOfPeople(EnumSet.of(AgeOfPeople.CHILD, AgeOfPeople.BABY));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithCollectionCodes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withCollectionCodes(Arrays.asList("WRI", "ARF"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithCollectionFilter() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withCollectionFilterType(CollectionFilter.EXCLUDE);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithExcludeNudity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withExcludeNudity(true);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithFormatAvailable() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withFormatAvailable(FormatAvailable.HD);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

   @Test
    void searchVideosCreativeWithFrameRates() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withFrameRates(EnumSet.of(FrameRate.FRAMERATE_24, FrameRate.FRAMERATE_29));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithKeywordIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withKeywordIds(Arrays.asList(1111,2222,3333));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithLicenseModels() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withLicenseModels(EnumSet.of(LicenseModel.RIGHTS_MANAGED));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithPage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withPage(3);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithPageSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withPageSize(50);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithPhrase() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withPhrase("cat");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithProductTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withProductTypes(EnumSet.of(ProductType.EASYACCESS, ProductType.EDITORIALSUBSCRIPTION));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithSortOrder() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withSortOrder(SortOrder.NEWEST);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithCustomParameter() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withCustomParameter("safe_search", "true");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchVideosCreativeWithCustomHeader() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchVideosCreative search = client.searchvideoscreative()
                .withCustomHeader("gi-country-code", "CAN");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @AfterAll
    public void stopProxy() { stopMockServers(); }
}
