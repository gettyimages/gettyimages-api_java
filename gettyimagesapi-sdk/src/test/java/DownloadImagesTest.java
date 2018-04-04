

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.Downloads.DownloadImages;
import com.gettyimages.api.Filters.FileType;
import com.gettyimages.api.Filters.ProductType;
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

public class DownloadImagesTest {
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
                        .withMethod("POST")
                        .withPath("/downloads/images/12345")
                        .withQueryStringParameters(
                                new Parameter("file_type", "jpg"),
                                new Parameter("auto_download", "false")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("POST")
                        .withPath("/downloads/images/12345")
                        .withQueryStringParameters(
                                new Parameter("auto_download", "false"),
                                new Parameter("height", "592")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("POST")
                        .withPath("/downloads/images/12345")
                        .withQueryStringParameters(
                                new Parameter("product_id", "9876"),
                                new Parameter("auto_download", "false")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
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
    void downloadImagesWithFileType() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withFileType(FileType.JPG);
        String result = downloadimages.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithHeight() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withHeight("592");
        String result = downloadimages.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithProductId() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withProductId(9876);
        String result = downloadimages.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }

    @Test
    void downloadImagesWithProductType() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        DownloadImages downloadimages = client.downloadimages()
                .withId("12345").withProductType(ProductType.EASYACCESS);
        String result = downloadimages.executeAsync();
        System.out.print(result);
        assertEquals("success", result);
    }


    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
