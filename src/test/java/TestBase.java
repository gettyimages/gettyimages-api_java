import com.gettyimages.api.ApiClient;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;

import java.lang.reflect.Field;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class TestBase {
    private ClientAndServer apiServerMock;
    protected MockServerClient apiClientMock;
    private ClientAndServer authServerMock;
    private MockServerClient authClientMock;

    protected void startMockServersAndSetupAuth() throws Exception {
        startMockServers();

        authClientMock
                .when(request()
                        .withMethod("POST")
                        .withPath("/oauth2/token")
                )
                .respond(response()
                        .withStatusCode(200)
                        .withBody("{ access_token: 'client_credentials_access_token', token_type: 'Bearer', expires_in: '1800' }")
                );
    }

    protected void startMockServers() throws Exception {
        final Field apiBaseUrl = ApiClient.class.getDeclaredField("apiBaseUrl");
        apiBaseUrl.setAccessible(true);
        apiBaseUrl.set(null, "http://127.0.0.1:1080/");

        final Field authenticationBaseUrl = ApiClient.class.getDeclaredField("authenticationBaseUrl");
        authenticationBaseUrl.setAccessible(true);
        authenticationBaseUrl.set(null, "http://127.0.0.1:1081/");
        apiServerMock = startClientAndServer(1080);
        authServerMock = startClientAndServer(1081);
        apiClientMock = new MockServerClient("127.0.0.1", 1080);
        authClientMock = new MockServerClient("127.0.0.1", 1081);
    }

    protected void stopMockServers() {
        apiServerMock.stop();
        authServerMock.stop();
    }
}
