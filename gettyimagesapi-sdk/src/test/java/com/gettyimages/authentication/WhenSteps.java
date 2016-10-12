package com.gettyimages.authentication;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.SharedContext;
import com.gettyimages.Token;
import cucumber.api.java.en.When;

/**
 * When steps for for authentication.feature
 */
public class WhenSteps {

    private Context context;

    public WhenSteps() {
        context = Context.getInstance();
    }

    @When("^I ask the sdk for an authentication token$")
    public void i_ask_the_sdk_for_an_authentication_token() throws Throwable {
        context.setAccessToken(getAccessToken());
    }

    @When("^I request an access token$")
    public void i_request_an_access_token() throws Throwable {
        context.setAccessToken(getAccessTokenViaRefreshToken(context.getRefreshToken()));
    }

    private static Token getAccessToken() throws SdkException {
        Credentials creds = Credentials.GetInstance(
                getProp(SharedContext.GETTYIMAGESAPI_ENV_NAME_APIKEY),
                getProp(SharedContext.GETTYIMAGESAPI_ENV_NAME_APISECRET),
                getProp(SharedContext.GETTYIMAGESAPI_ENV_NAME_USERNAME),
                getProp(SharedContext.GETTYIMAGESAPI_ENV_NAME_USERPASSWORD),
                SharedContext.BASEURL
        );
        return creds.GetAccessToken();
    }

    private static Token getAccessTokenViaRefreshToken(String refreshToken) throws SdkException {
        Credentials creds = Credentials.GetInstance(
                getProp(SharedContext.GETTYIMAGESAPI_ENV_NAME_APIKEY),
                getProp(SharedContext.GETTYIMAGESAPI_ENV_NAME_APISECRET),
                refreshToken,
                SharedContext.BASEURL
        );
        return creds.GetAccessToken();
    }

    private static String getProp(String gettyimagesapiEnvName) {
        return SharedContext.GetProp(gettyimagesapiEnvName);
    }
}
