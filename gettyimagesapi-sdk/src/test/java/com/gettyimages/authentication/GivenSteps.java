package com.gettyimages.authentication;

import cucumber.api.java.en.Given;

import static org.junit.Assert.assertTrue;

/**
 * Given steps for authentication.feature
 */
public class GivenSteps {

    private Context context;

    public GivenSteps() {
        context = Context.getInstance();
    }

    @Given("^a refresh token$")
    public void a_refresh_token() throws Throwable {
        context.setRefreshToken(context.getAccessToken().getRefreshTokenString());
        assertTrue("Refresh token should exist",
                context.getRefreshToken() != null && context.getRefreshToken().length() > 0);
    }
}
