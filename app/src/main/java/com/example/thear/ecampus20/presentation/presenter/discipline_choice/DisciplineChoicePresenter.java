package com.example.thear.ecampus20.presentation.presenter.discipline_choice;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.dagger.holder.TokenHolder;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.view.discipline_choice.DisciplineChoiceView;
import com.example.thear.ecampus20.service.CampusApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class DisciplineChoicePresenter extends MvpPresenter<DisciplineChoiceView> {

    private static final String TAG = "DCPresenter";
    @Inject
    TokenHolder tokenHolder;
    @Inject
    CampusApi api;
    private List<Semestr> semestrList = new ArrayList<>();

    public DisciplineChoicePresenter() {
        CampusApplication.getComponent().inject(this);
        getDisciplines();
    }

    private void getDisciplines() {
        getViewState().showProgressBar();
        Observable<List<Semestr>> call = api.getDisciplines("Bearer ".concat(tokenHolder.getToken().getAccessToken()));
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Semestr>>() {
                    @Override
                    public void onCompleted() {
                        getViewState().hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, e.getMessage());
                        getViewState().hideProgressBar();
                    }

                    @Override
                    public void onNext(List<Semestr> list) {
                        semestrList.clear();
                        semestrList.addAll(list);
                        getViewState().initializeViewPager(semestrList);
                    }
                });
    }
}
