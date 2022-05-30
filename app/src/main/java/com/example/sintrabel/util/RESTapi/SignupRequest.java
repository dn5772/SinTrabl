package com.example.sintrabel.util.RESTapi;

import com.google.gson.annotations.SerializedName;

public class SignupRequest {

    @SerializedName("nickname")
    public String inputNickName;

    @SerializedName("username")
    public String inputUserName;

    @SerializedName("password")
    public String inputPw;

    public String getInputNickName() {
        return inputNickName;
    }

    public String getInputUserName() {
        return inputUserName;
    }

    public String getInputPw() {
        return inputPw;
    }

    public void setInputNickName(String inputNickName){
        this.inputNickName = inputNickName;
    }

    public void setInputUserName(String inputUserName) {
        this.inputUserName = inputUserName;
    }

    public void setInputPw(String inputPw) {
        this.inputPw = inputPw;
    }

    public SignupRequest(String inputUserName, String inputPw, String inputNickName) {
        this.inputUserName = inputUserName;
        this.inputPw = inputPw;
        this.inputNickName = inputNickName;
    }

}
