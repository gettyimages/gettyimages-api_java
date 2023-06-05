

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Downloads.DownloadImages;
import com.gettyimages.api.Filters.FileType;
import com.gettyimages.api.Filters.ProductType;
import org.junit.jupiter.api.*;
import org.mockserver.model.Parameter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DownloadImagesTest extends TestBase {
    @BeforeAll
    public void startProxy() throws Exception {
        startMockServersAndSetupAuth();

        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/images/12345")
                                .withQueryStringParameters(
                                        new Parameter("auto_download", "false")
                                )
                                .withHeader("Accept-Language", "de")
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/images/12345")
                                .withQueryStringParameters(
                                        new Parameter("file_type", "jpg"),
                                        new Parameter("auto_download", "false")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/images/12345")
                                .withQueryStringParameters(
                                        new Parameter("auto_download", "false"),
                                        new Parameter("height", "592")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/images/12345")
                                .withQueryStringParameters(
                                        new Parameter("product_id", "9876"),
                                        new Parameter("auto_download", "false")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));
        apiClientMock.when(
                        request()
                                .withMethod("POST")
                                .withPath("/downloads/images/12345")
                                .withQueryStringParameters(
                                        new Parameter("product_type", "easyaccess"),
                                        new Parameter("auto_download", "false")
                                )
                )
                .respond(response().withStatusCode(200).withBody("success"));

    }

    @Test
    void downloadImagesWithAcceptLanguage() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withAcceptLanguage("de");
        String result = downloadimages.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithFileType() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withFileType(FileType.JPG);
        String result = downloadimages.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithHeight() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withHeight("592");
        String result = downloadimages.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithProductId() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withProductId(9876);
        String result = downloadimages.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithProductType() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withProductType(ProductType.EASYACCESS);
        String result = downloadimages.executeAsync();
        assertEquals("success", result);
    }


    @AfterAll
    public void stopProxy() {
        stopMockServers();
    }
}
