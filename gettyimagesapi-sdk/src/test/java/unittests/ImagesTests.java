package unittests;

import com.gettyimages.ApiClient;
import com.gettyimages.Images;
import com.gettyimages.SdkException;
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

public class ImagesTests {
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
                        .withPath("/images/12345")
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/images/12345")
                        .withQueryStringParameters(
                                new Parameter("fields", "country,id")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/images")
                        .withQueryStringParameters(
                                new Parameter("ids", "12345,678910")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));

    }

   @Test
    void imagesWithId() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            Images images = client.images()
                    .withId("12345");
            String result = images.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void imagesWithIdWithResponseFields() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            Images images = client.images()
                    .withId("12345").withResponseFields(Arrays.asList("country", "id"));
            String result = images.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }

    @Test
    void imagesWithIds() {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret", "http://127.0.0.1:1080");
        try {
            Images images = client.images()
                    .withIds(Arrays.asList("12345", "678910"));
            String result = images.executeAsync();
            System.out.print(result);
            assertEquals("success", result);
        } catch (SdkException e) {
            System.out.println("Exception occurred: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }


    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
