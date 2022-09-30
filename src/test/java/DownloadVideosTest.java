

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Downloads.DownloadVideos;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class DownloadVideosTest {
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
                                .withMethod("POST")
                                .withPath("/downloads/videos/12345")
                                .withQueryStringParameters(
                                        new Parameter("auto_download", "false")
                                )
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/videos/12345")
                                .withQueryStringParameters(
                                        new Parameter("product_id", "9876"),
                                        new Parameter("auto_download", "false")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/videos/12345")
                                .withQueryStringParameters(
                                        new Parameter("size", "size"),
                                        new Parameter("auto_download", "false")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));

    }

    @Test
    void downloadVideosWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadVideos downloadVideos = client.downloadvideos()
                .withId("12345").withAcceptLanguage("de");
        String result = downloadVideos.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void downloadVideosWithProductId() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadVideos downloadVideos = client.downloadvideos()
                .withId("12345").withProductId(9876);
        String result = downloadVideos.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void downloadVideosWithSize() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadVideos downloadVideos = client.downloadvideos()
                .withId("12345").withSize("size");
        String result = downloadVideos.executeAsync();
        assertEquals("success", result);
    }


    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
