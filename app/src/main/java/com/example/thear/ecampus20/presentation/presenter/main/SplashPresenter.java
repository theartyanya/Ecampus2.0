package com.example.thear.ecampus20.presentation.presenter.main;


import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.model.Token;
import com.example.thear.ecampus20.presentation.view.main.SplashView;
import com.example.thear.ecampus20.service.CampusApi;
import com.example.thear.ecampus20.ui.activity.main.Screens;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private static final String TAG = "SplashPresenter";

    @Inject
    Router router;
    @Inject
    CampusApi api;
    @Inject
    SharedPreferences preferences;

    public SplashPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void authUser() {
        final String login = preferences.getString(Constants.SHARED_PREFERENCES_LOGIN_TAG, null);
        final String password = preferences.getString(Constants.SHARED_PREFERENCES_PASS_TAG, null);
        getViewState().showProgressDialog();
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put("username", login);
        fieldsMap.put("password", password);
        fieldsMap.put("grant_type", "password");
        Observable<Token> call = api.auth(fieldsMap);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, e.getMessage());
                        getViewState().hideProgressDialog();
                        router.newRootScreen(Screens.LOGIN_SCREEN);
                        getViewState().showError("Помилка серверу, спробуйте ввести свій логін та пароль");
                        clearSharedPreferences();
                    }

                    @Override
                    public void onNext(Token token) {
                        getViewState().hideProgressDialog();
                        getViewState().onLoggedIn();
                        saveSharedPreferences(login, password);
                        router.newRootScreen(Screens.START_SCREEN);
                    }
                });
    }

    private void clearSharedPreferences() {
        preferences
                .edit()
                .remove(Constants.SHARED_PREFERENCES_LOGIN_TAG)
                .remove(Constants.SHARED_PREFERENCES_PASS_TAG)
                .apply();
    }

    private void saveSharedPreferences(String login, String password) {
        preferences
                .edit()
                .putString(Constants.SHARED_PREFERENCES_LOGIN_TAG, login)
                .putString(Constants.SHARED_PREFERENCES_PASS_TAG, password)
                .apply();
    }
}
