import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Videos.Videos;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockserver.model.Parameter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VideosTest extends TestBase {
    @BeforeAll
    public void startProxy() throws Exception {
        startMockServersAndSetupAuth();
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/videos/12345")
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/videos/12345")
                                .withQueryStringParameters(
                                        new Parameter("fields", "country,id")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
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
    void videosWithIdWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Videos videos = client.videos()
                .withId("12345").withAcceptLanguage("de");
        String result = videos.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void videosWithIdWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Videos videos = client.videos()
                .withId("12345").withResponseFields(Arrays.asList("country", "id"));
        String result = videos.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void videosWithIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Videos videos = client.videos()
                .withIds(Arrays.asList("12345", "678910"));
        String result = videos.executeAsync();
        assertEquals("success", result);
    }


    @AfterAll
    public void stopProxy() { stopMockServers(); }
}

