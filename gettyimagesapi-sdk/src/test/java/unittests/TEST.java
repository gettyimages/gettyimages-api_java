package unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;
import com.gettyimages.search.ImagesSearch;
import org.junit.jupiter.api.*;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;


public class TEST {

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
                                new Parameter("phrase", "cat")
                        )
                )
                .respond(response()
                        .withStatusCode(200)
                        .withBody("success")
                );
    }

    @Test
    void myFirstTest() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        String searchTerm = "cat";
        try {
            ImagesSearch search = client.search()
                    .images()
                    .creative()
                    .withPhrase(searchTerm);
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