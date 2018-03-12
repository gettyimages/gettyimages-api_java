import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;
import com.gettyimages.SearchImagesCreative;
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

public class SearchImagesCreativeTests {
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
                        .withPath("/search/images/creative")
                        .withQueryStringParameters(
                                new Parameter("age_of_people", "adult")
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
                                new Parameter("collection_filter_type", "exclude")
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
                                new Parameter("composition", "headshot,abstract")
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
                                new Parameter("number_of_people", "group,one")
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

//   @Test
//    void searchImagesCreativeWithAgeOfPeople() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
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
    void searchImagesCreativeWithArtist() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
                    .withArtists(Arrays.asList("roman makhmutov"));
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchImagesCreativeWithCollectionCodes() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
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
//    void searchImagesCreativeWithCollectionFilter() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
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
    void searchImagesCreativeWithColor() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
                    .withColor("#002244");
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
//    void searchImagesCreativeWithComposition() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withComposition(Composition.HEADSHOT | Composition.ABSTRACT);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchImagesCreativeWithEmbedContetOnly() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
                    .withEmbedContentOnly(true);
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

//    @Test
//    void searchImagesCreativeWithEthnicity() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withEthnicity(Ethnicity.BLACK | Ethnicity.JAPANESE);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchImagesCreativeWithExcludeNudity() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
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
    void searchImagesCreativeWithResponseFields() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
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
//    void searchImagesCreativeWithFileTypes() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withFileTypes(FileType.EPS | FileType.JPG);
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
//    void searchImagesCreativeWithGraphicalStyles() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withGraphicalStyles(GraphicalStyles.FINEART | GraphicalStyles.ILLUSTRATION);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchImagesCreativeWithKeywordIds() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
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
//    void searchImagesCreativeWithLicenseModels() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withLicenseModels(LicenseModel.RIGHTS_MANAGED);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

//    @Test
//    void searchImagesCreativeWithMinimumSize() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withMinimumSize(MinimumSize.SMALL);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

//    @Test
//    void searchImagesCreativeWithNumberOfPeople() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withNumberOfPeople(NumberOfPeople.GROUP | NumberOfPeople.ONE);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

//    @Test
//    void searchImagesCreativeWithOrientations() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
//                    .withOrientations(Orientation.HORIZONTAL | Orientation.SQUARE);
//            String result = search.executeAsync();
//            System.out.print(result);
//            assertEquals("success", result);
//        } catch (SdkException e) {
//            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
//            System.exit(-1);
//        }
//    }

    @Test
    void searchImagesCreativeWithPage() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
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
    void searchImagesCreativeWithPageSize() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
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
    void searchImagesCreativeWithPhrase() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
                    .withPhrase("cat");
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void searchImagesCreativeWithPrestigeContentOnly() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            SearchImagesCreative search = client.searchimagescreative()
                    .withPrestigeContentOnly(true);
            String result = search.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

//    @Test
//    void searchImagesCreativeWithProductTypes() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
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
//    void searchImagesCreativeWithSortOrder() {
//        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
//        try {
//            SearchImagesCreative search = client.searchimagescreative()
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
