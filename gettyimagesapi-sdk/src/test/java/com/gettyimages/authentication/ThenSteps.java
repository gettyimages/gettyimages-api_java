package com.gettyimages.authentication;

import com.gettyimages.Token;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

/**
 * Then steps for authentication.feature
 */
public class ThenSteps {

    private Context context;

    public ThenSteps() {
        context = Context.getInstance();
    }


    @Then("^an access token is returned$")
    public void an_access_token_is_returned() throws Throwable {
        assertTrue("Access token should be returned",
                accessToken().getTokenString() != null && accessToken().getTokenString().length() > 0);
    }

    @Then("^a token is returned$")
    public void a_token_is_returned() throws Throwable {
        assertTrue("Access token should be returned",
                accessToken().getTokenString() != null && accessToken().getTokenString().length() > 0);
    }

    private Token accessToken() {
        return context.getAccessToken();
    }
}
