package com.example.thear.ecampus20.service;

import com.example.thear.ecampus20.model.rnp.NpModel;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface NpApi {
    @GET("/Np")
    Observable<List<NpModel>> getNp();
}
