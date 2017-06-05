package com.example.thear.ecampus20.model.rnp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NpApi {
    @GET("/Np")
    Call<List<NpModel>> getNp();
}
