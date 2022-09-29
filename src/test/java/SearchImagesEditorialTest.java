
import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.Search.SearchImagesEditorial;
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

public class SearchImagesEditorialTest {
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
                                .withPath("/search/images/editorial")
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("age_of_people", "baby,child,adult")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("artists", "roman makhmutov")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("collection_codes", "WRI,ARF")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("collections_filter_type", "exclude")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("compositions", "abstract,headshot")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("editorial_segments", "archival,publicity")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("embed_content_only", "true")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("end_date", "2015-04-01")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("entity_uris", "uri1,uri2")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("ethnicity", "black,japanese")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("event_ids", "123,456,789")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("exclude_nudity", "true")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("fields", "asset_family,id,uri_oembed")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("file_types", "eps,jpg")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("graphical_styles", "fine_art,illustration")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("keyword_ids", "1111,2222,3333")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("minimum_quality_rank", "1")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("minimum_size", "small")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("number_of_people", "one,group")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("orientations", "Horizontal,Square")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("page", "3")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("page_size", "50")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("phrase", "cat")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("product_types", "easyaccess,editorialsubscription")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("sort_order", "newest")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("specific_people", "Reggie Jackson")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("GET")
                                .withPath("/search/images/editorial")
                                .withQueryStringParameters(
                                        new Parameter("start_date", "2015-04-01")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
    }

    @Test
    void searchImagesEditorialWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withAcceptLanguage("de");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithAgeOfPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withAgeOfPeople(EnumSet.of(AgeOfPeople.ADULT)).withAgeOfPeople(EnumSet.of(AgeOfPeople.CHILD, AgeOfPeople.BABY));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithArtist() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withArtists(Arrays.asList("roman makhmutov"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithCollectionCodes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withCollectionCodes(Arrays.asList("WRI", "ARF"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithCollectionFilter() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withCollectionFilterType(CollectionFilter.EXCLUDE);
        String result = search.executeAsync();
        assertEquals("success", result);
    }


    @Test
    void searchImagesEditorialWithComposition() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withCompositions(EnumSet.of(Compositions.HEADSHOT, Compositions.ABSTRACT));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithEditorialSegments() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withEditorialSegments(EnumSet.of(EditorialSegment.ARCHIVAL, EditorialSegment.PUBLICITY));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithEmbedContentOnly() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withEmbedContentOnly(true);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithEndDate() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withEndDate("2015-04-01");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithEntityUris() throws Exception{
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withEntityUris(Arrays.asList("uri1", "uri2"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithEthnicity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withEthnicity(EnumSet.of(Ethnicity.BLACK, Ethnicity.JAPANESE));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithEventIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withEventIds(Arrays.asList(123, 456, 789));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithExcludeNudity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withExcludeNudity(true);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithFileTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withFileTypes(EnumSet.of(FileType.EPS, FileType.JPG));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

   @Test
    void searchImagesEditorialWithGraphicalStyles() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withGraphicalStyles(EnumSet.of(GraphicalStyles.FINE_ART, GraphicalStyles.ILLUSTRATION));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithKeywordIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withKeywordIds(Arrays.asList(1111,2222,3333));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithMinimumQualityRank() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withMinimumQualityRank(MinimumQualityRank.ONE);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithMinimumSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withMinimumSize(MinimumSize.SMALL);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithNumberOfPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withNumberOfPeople(EnumSet.of(NumberOfPeople.GROUP, NumberOfPeople.ONE));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithOrientations() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withOrientations(EnumSet.of(Orientation.HORIZONTAL, Orientation.SQUARE));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithPage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withPage(3);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithPageSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withPageSize(50);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithPhrase() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withPhrase("cat");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithProductTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withProductTypes(EnumSet.of(ProductType.EASYACCESS, ProductType.EDITORIALSUBSCRIPTION));
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithSortOrder() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withSortOrder(SortOrder.NEWEST);
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void searchImagesEditorialWithSpecificPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withSpecificPeople(Arrays.asList("Reggie Jackson"));
        String result = search.executeAsync();
        assertEquals("success", result);
    }


    @Test
    void searchImagesEditorialWithStartDate() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesEditorial search = client.searchimageseditorial()
                .withStartDate("2015-04-01");
        String result = search.executeAsync();
        assertEquals("success", result);
    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}