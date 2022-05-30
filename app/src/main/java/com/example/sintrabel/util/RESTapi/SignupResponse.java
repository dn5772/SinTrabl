package com.example.sintrabel.util.RESTapi;

import com.google.gson.annotations.SerializedName;

public class SignupResponse {

    @SerializedName("result")
    public String resultCode;

    @SerializedName("userId")
    public String userId;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getUserId() { return userId; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
