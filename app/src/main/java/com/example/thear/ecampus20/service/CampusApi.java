package com.example.thear.ecampus20.service;

import com.example.thear.ecampus20.model.Token;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by aleks on 14.05.2017.
 */

public interface CampusApi {
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("oauth/token")
    Observable<Token> auth(@FieldMap Map<String, String> fields);
}
