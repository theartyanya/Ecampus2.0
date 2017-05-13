package com.example.thear.ecampus20.presentation.presenter.main;


import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.main.LoginView;
import com.example.thear.ecampus20.ui.activity.main.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    @Inject
    Router router;

    private boolean isButtonClicked = false;

    public LoginPresenter() {
        CampusApplication.getComponent().inject(this);
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
            getViewState().onLoggedIn();
            router.newRootScreen(Screens.START_SCREEN);
        }
    }
}
