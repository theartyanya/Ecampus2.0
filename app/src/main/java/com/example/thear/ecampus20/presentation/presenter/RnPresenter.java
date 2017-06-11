package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.service.NpApi;
import com.example.thear.ecampus20.model.rnp.NpModel;
import com.example.thear.ecampus20.presentation.view.RnView;
import com.example.thear.ecampus20.ui.activity.MainActivity;
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
public class RnPresenter extends MvpPresenter<RnView> {
    @Inject
    Router router;

    public RnPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void loadData(final List<NpModel> list) {
        RxJavaCallAdapterFactory factory = RxJavaCallAdapterFactory.create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://demo8458783.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(factory).build();
        NpApi api = retrofit.create(NpApi.class);

        api.getNp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NpModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<NpModel> npList) {
                        list.addAll(npList);
                        getViewState().updateView();
                    }
                });
    }

    public void openDetailsScreen(NpModel item) {
        getViewState().unmapFragment();
        router.navigateTo(Screens.NP_DETAILS, item);
    }


}
