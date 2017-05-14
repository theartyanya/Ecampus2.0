package com.example.thear.ecampus20.presentation.presenter.main;


import android.text.TextUtils;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.model.Token;
import com.example.thear.ecampus20.presentation.view.main.LoginView;
import com.example.thear.ecampus20.service.CampusApi;
import com.example.thear.ecampus20.service.Path;
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
public class LoginPresenter extends MvpPresenter<LoginView> {

    private static final String TAG = "LoginPresenter";

    @Inject
    Router router;
    @Inject
    CampusApi api;
    private boolean isButtonClicked = false;

    public LoginPresenter() {
        CampusApplication.getComponent().inject(this);
        Log.d("mytag", Path.path);
    }

    public boolean validateLogin(String str) {
        if (isButtonClicked) {
            if (TextUtils.isEmpty(str)) {
                getViewState().showLoginError("Введіть логін");
            } else {
                getViewState().showLoginError(null);
                return true;
            }
        }
        return false;
    }

    public boolean validatePassword(String str) {
        if (isButtonClicked) {
            if (TextUtils.isEmpty(str)) {
                getViewState().showPasswordError("Введіть пароль");
            } else {
                getViewState().showPasswordError(null);
                return true;
            }
        }
        return false;
    }

    public void onLoginButtonClicked(String login, String password) {
        isButtonClicked = true;
        if (validateLogin(login) & validatePassword(password)) {
            authUser(login, password);
        }
    }

    public void authUser(String login, String password) {
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
                    }

                    @Override
                    public void onNext(Token token) {
                        getViewState().hideProgressDialog();
                        getViewState().onLoggedIn();
                        router.newRootScreen(Screens.START_SCREEN);
                    }
                });
    }
}
