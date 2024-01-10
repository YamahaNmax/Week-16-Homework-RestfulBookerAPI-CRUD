package com.herokuapp.model;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class TokenPojo {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static TokenPojo getTokenBody(String username, String password) {
        TokenPojo tokenPojo = new TokenPojo();
        tokenPojo.setUsername(username);
        tokenPojo.setPassword(password);
        return tokenPojo;
    }

}