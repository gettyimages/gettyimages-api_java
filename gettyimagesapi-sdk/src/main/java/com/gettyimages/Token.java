package com.gettyimages;

import java.util.Date;

public class Token
{
    private String RefreshTokenString;
    private Date Expiration;
    private String TokenString;

    Token() { }

    public String getRefreshTokenString() {
        return RefreshTokenString;
    }

    public void setRefreshTokenString(String refreshTokenString) {
        RefreshTokenString = refreshTokenString;
    }

    public Date getExpiration() {
        return Expiration;
    }

    public void setExpiration(Date expiration) {
        Expiration = expiration;
    }

    public String getTokenString() {
        return TokenString;
    }

    public void setTokenString(String tokenString) {
        TokenString = tokenString;
    }
}
