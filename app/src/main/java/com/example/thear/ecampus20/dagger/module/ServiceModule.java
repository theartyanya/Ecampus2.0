package com.example.thear.ecampus20.dagger.module;

import com.example.thear.ecampus20.service.CampusApi;
import com.example.thear.ecampus20.service.Path;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {
    private Retrofit retrofit;
    private CampusApi api;


    public ServiceModule() {
        retrofit = buildRetrofit(buildClient());
        api = createService();
    }

    private OkHttpClient buildClient() {
        return new OkHttpClient.Builder().build();
    }

    private Retrofit buildRetrofit(OkHttpClient client) {
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(Path.path)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );
        return builder
                .client(client)
                .build();
    }

    private CampusApi createService() {
        return retrofit.create(CampusApi.class);
    }

    @Provides
    @Singleton
    CampusApi provideService() {
        return api;
    }
}
