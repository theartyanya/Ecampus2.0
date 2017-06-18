package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.model.Discipline;
import com.example.thear.ecampus20.model.DisciplineModel;
import com.example.thear.ecampus20.model.RnpModel;
import com.example.thear.ecampus20.presentation.view.DisciplineView;
import com.example.thear.ecampus20.service.CampusApi;
import com.example.thear.ecampus20.ui.activity.Screens;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.terrakok.cicerone.Router;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class DisciplinePresenter extends MvpPresenter<DisciplineView> {
    @Inject
    Router router;

    public DisciplinePresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void loadData(final List<DisciplineModel> items) {
        RxJavaCallAdapterFactory factory = RxJavaCallAdapterFactory.create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://demo8458783.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(factory).build();

        CampusApi api = retrofit.create(CampusApi.class);

        api.getDisciplines()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<DisciplineModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<DisciplineModel> rnpModels) {
                        items.addAll(rnpModels);
                        getViewState().updateView();
                    }
                });
    }
}
