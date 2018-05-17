package br.com.supra.gestaoescolar;

import java.io.Serializable;

public class Auth implements Serializable {

    public Auth() {

    }

    private String token_type;
    private String expires_in;
    private String access_token;
    private String refresh_tokenString;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_tokenString() {
        return refresh_tokenString;
    }

    public void setRefresh_tokenString(String refresh_tokenString) {
        this.refresh_tokenString = refresh_tokenString;
    }


}
