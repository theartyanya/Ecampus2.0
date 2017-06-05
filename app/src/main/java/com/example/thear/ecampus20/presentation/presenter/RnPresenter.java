package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.model.rnp.NpApi;
import com.example.thear.ecampus20.model.rnp.NpModel;
import com.example.thear.ecampus20.presentation.view.RnView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class RnPresenter extends MvpPresenter<RnView> {
    public void loadData(final List<NpModel> list) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api-campus-kpi-ua.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        NpApi api = retrofit.create(NpApi.class);

        api.getNp().enqueue(new Callback<List<NpModel>>() {
            @Override
            public void onResponse(Call<List<NpModel>> call, Response<List<NpModel>> response) {
                list.addAll(response.body());
                getViewState().updateView();
            }

            @Override
            public void onFailure(Call<List<NpModel>> call, Throwable t) {}
        });
    }
}
