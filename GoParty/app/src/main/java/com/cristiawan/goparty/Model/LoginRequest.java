package com.cristiawan.goparty.Model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("username")
    private  String username;
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
}
