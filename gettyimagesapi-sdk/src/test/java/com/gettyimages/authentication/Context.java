package com.gettyimages.authentication;

import com.gettyimages.Token;

/**
 * Context class for authentication.feature
 */
public class Context {

    private Token accessToken;
    private String refreshToken;
    private Context(){}

    private static class ContextHelper {
        private static final Context INSTANCE = new Context();
    }

    public static Context getInstance() {
        return ContextHelper.INSTANCE;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }
}
