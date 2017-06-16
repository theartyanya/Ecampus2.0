package com.example.thear.ecampus20.service;

import com.example.thear.ecampus20.model.CreditModel;
import com.example.thear.ecampus20.model.DisciplineModel;
import com.example.thear.ecampus20.model.RnpModel;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.model.StudentInfo;
import com.example.thear.ecampus20.model.Token;
import com.example.thear.ecampus20.model.rnp.NpModel;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface CampusApi {
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("oauth/token")
    Observable<Token> auth(@FieldMap Map<String, String> fields);

    @Headers("Accept: application/json")
    @GET("Account/student/group")
    Observable<StudentInfo> getStudentInfo(@Header("Authorization") String token);

    @Headers("Accept: application/json")
    @GET("SelectiveDiscipline/semesters/disciplines")
    Observable<List<Semestr>> getDisciplines(@Header("Authorization") String token);

    @GET("/Np")
    Observable<List<NpModel>> getNp();

    @GET("RNP/Np")
    Observable<List<RnpModel>> getRnp();

    @GET("/StudyOrganization/Discipline")
    Observable<List<DisciplineModel>> getDisciplines();

    @GET("/CreditModule/14")
    Observable<List<CreditModel>> getCreditModule();
}
