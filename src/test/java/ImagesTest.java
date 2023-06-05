

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Images.Images;
import org.junit.jupiter.api.*;
import org.mockserver.model.Parameter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ImagesTest extends TestBase {
    @BeforeAll
    public void startProxy() throws Exception {
        startMockServersAndSetupAuth();

        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/images/12345")
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("GET")
                                .withPath("/images/12345")
                                .withQueryStringParameters(
                                        new Parameter("fields", "country,id")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
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
    void imagesWithIdWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Images images = client.images()
                .withId("12345").withAcceptLanguage("de");
        String result = images.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void imagesWithIdWithResponseFields() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Images images = client.images()
                .withId("12345").withResponseFields(Arrays.asList("country", "id"));
        String result = images.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void imagesWithIds() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Images images = client.images()
                .withIds(Arrays.asList("12345", "678910"));
        String result = images.executeAsync();
        assertEquals("success", result);
    }


    @AfterAll
    public void stopProxy() {
        stopMockServers();
    }
}
