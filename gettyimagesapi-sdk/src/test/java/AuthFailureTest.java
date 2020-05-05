import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.lang.reflect.Field;

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.HttpClientErrorException;
import com.gettyimages.api.HttpSystemErrorException;
import com.gettyimages.api.Search.SearchImages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

public class AuthFailureTest {
    private ClientAndServer mockServer;

    @BeforeEach
    public void startProxy() throws Exception {
            final Field field = ApiClient.class.getDeclaredField("baseUrl");
            field.setAccessible(true);
            field.set(null, "http://127.0.0.1:1080/");
            mockServer = startClientAndServer(1080);
    }

    @Test
    void clientErrorOnAuthentication() throws Exception {
        final int statusCode = 400;
        createMock(statusCode);
        final ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        final SearchImages search = client.searchimages()
                .withPhrase("cat");

        final HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> { search.executeAsync(); } );
        assertEquals(exception.getStatusCode(), statusCode);
    }

    @Test
    void systemErrorOnAuthentication() throws Exception {
        final int statusCode = 500;
        createMock(statusCode);
        final ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        final SearchImages search = client.searchimages()
                .withPhrase("cat");

        final HttpSystemErrorException exception = assertThrows(HttpSystemErrorException.class, () -> { search.executeAsync(); } );
        assertEquals(exception.getStatusCode(), statusCode);
    }


    @AfterEach
    public void stopProxy() {
        mockServer.stop();
    }

    private void createMock(final int statusCode) {
            final MockServerClient client = new MockServerClient("127.0.0.1", 1080);

            client.when(request().withMethod("POST").withPath("/oauth2/token"))
                            .respond(response().withStatusCode(statusCode));
            client.when(request().withMethod("GET").withPath("/search/images")
                            .withQueryStringParameters(new Parameter("phrase", "cat")))
                            .respond(response().withStatusCode(200).withBody("success"));
    }
}
