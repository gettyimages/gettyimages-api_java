
import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Filters.*;
import com.gettyimages.api.Search.SearchImagesCreative;
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

public class SearchImagesCreativeTest {
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
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("age_of_people", "baby,child,adult")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("artists", "roman makhmutov")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("collection_codes", "WRI,ARF")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("collections_filter_type", "exclude")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("color", "#002244")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("compositions", "abstract,headshot")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("embed_content_only", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("ethnicity", "black,japanese")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("exclude_nudity", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("fields", "asset_family,id,uri_oembed")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("file_types", "eps,jpg")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("graphical_styles", "fine_art,illustration")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("keyword_ids", "1111,2222,3333")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("license_models", "rightsmanaged")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("minimum_size", "small")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("number_of_people", "one,group")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("orientations", "Horizontal,Square")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("page", "3")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("page_size", "50")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("phrase", "cat")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("prestige_content_only", "true")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("product_types", "easyaccess,editorialsubscription")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("sort_order", "newest")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
    }

   @Test
    void searchImagesCreativeWithAgeOfPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withAgeOfPeople(EnumSet.of(AgeOfPeople.ADULT)).withAgeOfPeople(EnumSet.of(AgeOfPeople.CHILD, AgeOfPeople.BABY));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithArtist() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withArtists(Arrays.asList("roman makhmutov"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithCollectionCodes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withCollectionCodes(Arrays.asList("WRI", "ARF"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithCollectionFilter() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withCollectionFilterType(CollectionFilter.EXCLUDE);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithColor() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withColor("#002244");
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }


    @Test
    void searchImagesCreativeWithComposition() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withCompositions(EnumSet.of(Compositions.HEADSHOT, Compositions.ABSTRACT));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithEmbedContetOnly() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withEmbedContentOnly(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithEthnicity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withEthnicity(EnumSet.of(Ethnicity.BLACK, Ethnicity.JAPANESE));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithExcludeNudity() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withExcludeNudity(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withResponseFields(Arrays.asList("asset_family", "id", "uri_oembed"));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithFileTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withFileTypes(EnumSet.of(FileType.EPS, FileType.JPG));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

   @Test
    void searchImagesCreativeWithGraphicalStyles() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withGraphicalStyles(EnumSet.of(GraphicalStyles.FINE_ART, GraphicalStyles.ILLUSTRATION));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithKeywordIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withKeywordIds(Arrays.asList(1111,2222,3333));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithLicenseModels() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withLicenseModels(EnumSet.of(LicenseModel.RIGHTS_MANAGED));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithMinimumSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withMinimumSize(MinimumSize.SMALL);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithNumberOfPeople() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withNumberOfPeople(EnumSet.of(NumberOfPeople.GROUP, NumberOfPeople.ONE));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithOrientations() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withOrientations(EnumSet.of(Orientation.HORIZONTAL, Orientation.SQUARE));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithPage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withPage(3);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithPageSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withPageSize(50);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithPhrase() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withPhrase("cat");
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithPrestigeContentOnly() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withPrestigeContentOnly(true);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithProductTypes() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withProductTypes(EnumSet.of(ProductType.EASYACCESS, ProductType.EDITORIALSUBSCRIPTION));
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void searchImagesCreativeWithSortOrder() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        SearchImagesCreative search = client.searchimagescreative()
                .withSortOrder(SortOrder.NEWEST);
        String result = search.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
