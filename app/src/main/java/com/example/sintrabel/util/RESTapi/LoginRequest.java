package com.example.sintrabel.util.RESTapi;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("username")
    public String inputUserName;

    @SerializedName("password")
    public String inputPw;


    public String getInputUserName() {
        return inputUserName;
    }

    public String getInputPw() {
        return inputPw;
    }

    public void setInputEmail(String inputUserName) {
        this.inputUserName = inputUserName;
    }

    public void setInputPw(String inputPw) {
        this.inputPw = inputPw;
    }

    public LoginRequest(String inputUserName, String inputPw) {
        this.inputUserName = inputUserName;
        this.inputPw = inputPw;
    }
}
