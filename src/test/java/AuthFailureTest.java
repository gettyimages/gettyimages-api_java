import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import com.gettyimages.api.ApiClient;
import com.gettyimages.api.HttpClientErrorException;
import com.gettyimages.api.HttpSystemErrorException;
import com.gettyimages.api.Search.SearchImages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.Parameter;

public class AuthFailureTest extends TestBase {
    @BeforeEach
    public void startProxy() throws Exception {
        startMockServers();
    }

    @Test
    void clientErrorOnAuthentication() throws Exception {
        final int statusCode = 400;
        createMock(statusCode);
        final ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        final SearchImages search = client.searchimages()
                .withPhrase("cat");

        final HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> { search.executeAsync(); } );
        assertEquals(statusCode, exception.getStatusCode());
    }

    @Test
    void systemErrorOnAuthentication() throws Exception {
        final int statusCode = 500;
        createMock(statusCode);
        final ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        final SearchImages search = client.searchimages()
                .withPhrase("cat");

        final HttpSystemErrorException exception = assertThrows(HttpSystemErrorException.class, () -> { search.executeAsync(); } );
        assertEquals(statusCode, exception.getStatusCode());
    }

    @AfterEach
    public void stopProxy() {
        stopMockServers();
    }

    private void createMock(final int statusCode) {
            final MockServerClient client = new MockServerClient("127.0.0.1", 1081);

            client.when(request().withMethod("POST").withPath("/oauth2/token"))
                            .respond(response().withStatusCode(statusCode));
            client.when(request().withMethod("GET").withPath("/search/images")
                            .withQueryStringParameters(new Parameter("phrase", "cat")))
                            .respond(response().withStatusCode(200).withBody("success"));
    }
}
