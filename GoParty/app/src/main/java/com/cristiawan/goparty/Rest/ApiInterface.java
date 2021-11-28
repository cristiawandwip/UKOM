package com.cristiawan.goparty.Rest;

import com.cristiawan.goparty.Model.GetBarang;
import com.cristiawan.goparty.Model.GetHistory;
import com.cristiawan.goparty.Model.History;
import com.cristiawan.goparty.Model.LoginRequest;
import com.cristiawan.goparty.Model.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("api/barang")
    Call<GetBarang> getBarang();

    @GET("api/order")
    Call<GetHistory> gethistory();

    @POST("api/loginpelanggan")
    Call<LoginResponse> loginuser(@Body LoginRequest loginRequest);



}