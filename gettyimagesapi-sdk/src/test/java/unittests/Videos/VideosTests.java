package unittests.Videos;

import com.gettyimages.ApiClient;
import com.gettyimages.Videos.Videos;
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

public class VideosTests {
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
                        .withPath("/videos/12345")
                        .withQueryStringParameters(
                                new Parameter("fields", "country,id")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("GET")
                        .withPath("/videos")
                        .withQueryStringParameters(
                                new Parameter("ids", "12345,678910")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));

    }

    @Test
    void videosWithIdWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Videos videos = client.videos()
                .withId("12345").withResponseFields(Arrays.asList("country", "id"));
        String result = videos.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void videosWithIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Videos videos = client.videos()
                .withIds(Arrays.asList("12345", "678910"));
        String result = videos.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }


    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}

