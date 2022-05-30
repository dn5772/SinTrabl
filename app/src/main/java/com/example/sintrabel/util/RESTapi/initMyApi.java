package com.example.sintrabel.util.RESTapi;

import retrofit2.Call;
import retrofit2.http.*;

public interface initMyApi {
    @POST("/account/signin")
    Call<LoginResponse> getLoginResponse(@Body LoginRequest loginRequest);

//    @Header()
    @POST("/account/signup")
    Call<SignupResponse> getSingupResponse(@Body SignupRequest signupRequest);
}
