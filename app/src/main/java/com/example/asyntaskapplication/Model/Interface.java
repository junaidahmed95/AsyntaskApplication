package com.example.asyntaskapplication.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {

    @GET("featured/stores")
    Call<List<AsynList>> list();
}
