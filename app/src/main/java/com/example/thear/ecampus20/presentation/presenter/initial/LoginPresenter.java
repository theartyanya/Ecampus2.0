package com.example.thear.ecampus20.presentation.presenter.initial;


import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.presentation.view.initial.LoginView;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {


    private boolean isButtonClicked = false;

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
            //perform login
        }
    }
}
