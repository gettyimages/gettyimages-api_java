package unittests.CustomRequest;

import com.gettyimages.ApiClient;
import com.gettyimages.CustomRequest.CustomRequest;
import com.gettyimages.Filters.Compositions;

import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.MatchType;
import org.mockserver.model.Parameter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;

public class CustomRequestTests {
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
                        .withPath("/search/images")
                        .withQueryStringParameters(
                                new Parameter("phrase", "cat"),
                                new Parameter("compositions", "abstract,full_frame")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("POST")
                        .withPath("/downloads/images/12345")
                        .withQueryStringParameters(
                                new Parameter("auto_download", "false")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("POST")
                        .withPath("/boards")
                        .withBody(
                                json("{" + System.lineSeparator() +
                                        "   \"name\": \"new board\"," + System.lineSeparator() +
                                        "   \"description\": \"new description\"" + System.lineSeparator() +
                                        "}",
                                    MatchType.STRICT
                                )
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("PUT")
                        .withPath("/asset-changes/change-sets")
                        .withQueryStringParameters(
                                new Parameter("channel_id", "3")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("PUT")
                        .withPath("/boards/111")
                        .withBody(
                                json("{" + System.lineSeparator() +
                                                "   \"name\": \"new board\"," + System.lineSeparator() +
                                                "   \"description\": \"new description\"" + System.lineSeparator() +
                                                "}",
                                        MatchType.STRICT
                                )
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));
        client.when(
                request()
                        .withMethod("DELETE")
                        .withPath("/boards/333")
                        .withQueryStringParameters(
                                new Parameter("asset_ids", "1234,5678")
                        )
        )
                .respond(response().withStatusCode(200).withBody("success"));

    }

    @Test
    void customRequestGetWithParams() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Map params = new HashMap();
        params.put("phrase", "cat");
        params.put("compositions", EnumSet.of(Compositions.ABSTRACT, Compositions.FULL_FRAME));
        CustomRequest request = client.customrequest()
                .withMethod("GET").withRoute("/search/images").withQueryParameters(params);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestPost() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Map map = new HashMap();
        map.put("auto_download", "false");
        CustomRequest request = client.customrequest()
                .withMethod("POST").withRoute("/downloads/images/12345").withQueryParameters(map);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestPostWithJsonObjectBody() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        JSONObject json = new JSONObject();
        json.put("name", "new board");
        json.put("description", "new description");
        CustomRequest request = client.customrequest()
                .withMethod("POST").withRoute("/boards").withBody(json);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestPostWithStringBody() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        JSONObject json = new JSONObject();
        json.put("name", "new board");
        json.put("description", "new description");
        String body = json.toString();
        CustomRequest request = client.customrequest()
                .withMethod("POST").withRoute("/boards").withBody(body);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestPostWithByteArrayEntityBody() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        JSONObject json = new JSONObject();
        json.put("name", "new board");
        json.put("description", "new description");
        ByteArrayEntity body = new ByteArrayEntity(json.toString().getBytes("UTF-8"));
        CustomRequest request = client.customrequest()
                .withMethod("POST").withRoute("/boards").withBody(body);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestPutWithParams() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Map params = new HashMap();
        params.put("channel_id", 3);
        CustomRequest request = client.customrequest()
                .withMethod("PUT").withRoute("/asset-changes/change-sets").withQueryParameters(params);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestPutWithJsonObjectBody() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        JSONObject json = new JSONObject();
        json.put("name", "new board");
        json.put("description", "new description");
        CustomRequest request = client.customrequest()
                .withMethod("PUT").withRoute("/boards/111").withBody(json);
        String result = request.executeAsync();
        assertEquals("success", result);
    }

    @Test
    void customRequestDeleteWithParams() throws Exception {
        ApiClient client = ApiClient.GetApiClientWithClientCredentials("apiKey", "apiSecret");
        Map params = new HashMap();
        params.put("asset_ids", Arrays.asList("1234", "5678"));
        CustomRequest request = client.customrequest()
                .withMethod("DELETE").withRoute("/boards/333").withQueryParameters(params);
        String result = request.executeAsync();
        assertEquals("success", result);
    }


    @AfterAll
    public static void stopProxy() {
        mockServer.stop();
    }
}
