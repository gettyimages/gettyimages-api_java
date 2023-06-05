

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Downloads.DownloadVideos;
import org.junit.jupiter.api.*;
import org.mockserver.model.Parameter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DownloadVideosTest extends TestBase {
    @BeforeAll
    public void startProxy() throws Exception {
        startMockServersAndSetupAuth();

        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/videos/12345")
                                .withQueryStringParameters(
                                        new Parameter("auto_download", "false")
                                )
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/videos/12345")
                                .withQueryStringParameters(
                                        new Parameter("product_id", "9876"),
                                        new Parameter("auto_download", "false")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
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
    public void stopProxy() { stopMockServers(); }
}
