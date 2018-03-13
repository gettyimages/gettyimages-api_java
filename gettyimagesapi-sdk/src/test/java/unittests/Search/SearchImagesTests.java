package unittests.Search;

import com.gettyimages.ApiClient;
import com.gettyimages.Search.SearchImages;
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

public class SearchImagesTests {
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
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("age_of_people", "adult")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("artists", "roman makhmutov")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("collection_codes", "WRI,ARF")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("collection_filter_type", "exclude")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("color", "#002244")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("composition", "headshot,abstract")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("embed_content_only", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("ethnicity", "black,japanese")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("event_ids", "123,456,789")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("exclude_nudity", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("fields", "asset_family,id,uri_oembed")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("file_types", "eps,jpg")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("graphical_styles", "fine_art,illustration")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("keyword_ids", "1111,2222,3333")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("license_models", "rightsmanaged")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("minimum_size", "small")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("number_of_people", "group,one")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("orientations", "Horizontal,Square")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("page", "3")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("page_size", "50")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("phrase", "cat")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("prestige_content_only", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("product_types", "easyaccess,editorialsubscription")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("sort_order", "newest")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("specific_people", "Reggie Jackson")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
    }

    //   @Test
//    void searchImagesWithAgeOfPeople() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withAgeOfPeople(AgeOfPeople.ADULT);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithArtist() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withArtists(Arrays.asList("roman makhmutov"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesWithCollectionCodes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withCollectionCodes(Arrays.asList("WRI", "ARF"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }
//
//    @Test
//    void searchImagesWithCollectionFilter() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withCollectionFilter(CollectionFilter.EXCLUDE);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithColor() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withColor("#002244");
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    //
//    @Test
//    void searchImagesWithComposition() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withComposition(Composition.HEADSHOT | Composition.ABSTRACT);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithEmbedContetOnly() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withEmbedContentOnly(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchImagesWithEthnicity() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withEthnicity(Ethnicity.BLACK | Ethnicity.JAPANESE);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithEventIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withEventIds(Arrays.asList(123, 456, 789));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesWithExcludeNudity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withExcludeNudity(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchImagesWithFileTypes() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withFileTypes(FileType.EPS | FileType.JPG);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }
//
//   @Test
//    void searchImagesWithGraphicalStyles() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withGraphicalStyles(GraphicalStyles.FINEART | GraphicalStyles.ILLUSTRATION);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithKeywordIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withKeywordIds(Arrays.asList(1111,2222,3333));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchImagesWithLicenseModels() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withLicenseModels(LicenseModel.RIGHTS_MANAGED);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

//    @Test
//    void searchImagesWithMinimumSize() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withMinimumSize(MinimumSize.SMALL);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

//    @Test
//    void searchImagesWithNumberOfPeople() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withNumberOfPeople(NumberOfPeople.GROUP | NumberOfPeople.ONE);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

//    @Test
//    void searchImagesWithOrientations() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withOrientations(Orientation.HORIZONTAL | Orientation.SQUARE);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithPage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withPage(3);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesWithPageSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withPageSize(50);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesWithPhrase() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withPhrase("cat");
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesWithPrestigeContentOnly() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withPrestigeContentOnly(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

//    @Test
//    void searchImagesWithProductTypes() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withProductTypes(ProductType.EASYACCESS | ProductType.EDITORIALSUBSCRIPTION);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

//    @Test
//    void searchImagesWithSortOrder() throws Exception {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
//        SearchImages search = client.searchimages()
//                .withSortOrder(SortOrder.NEWEST);
//        String result = search.executeAsync();
//        System.out.print(result);
//        assertEquals("success", result);
//    }

    @Test
    void searchImagesWithSpecificPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImages search = client.searchimages()
                .withSpecificPeople(Arrays.asList("Reggie Jackson"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
