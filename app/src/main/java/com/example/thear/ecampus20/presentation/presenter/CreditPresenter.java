package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.model.CreditModel;
import com.example.thear.ecampus20.model.RnpModel;
import com.example.thear.ecampus20.presentation.view.CreditView;
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
public class CreditPresenter extends MvpPresenter<CreditView>{
    @Inject
    Router router;

    public CreditPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void loadData(final List<CreditModel> items) {
        RxJavaCallAdapterFactory factory = RxJavaCallAdapterFactory.create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://demo8458783.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(factory).build();

        CampusApi api = retrofit.create(CampusApi.class);

        api.getCreditModule()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CreditModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<CreditModel> creditModels) {
                        items.addAll(creditModels);
                        getViewState().updateView();
                    }
                });
    }

    public void moveToDetails(CreditModel model) {
        router.navigateTo(Screens.RNP_DETAILS, model);
    }
}
