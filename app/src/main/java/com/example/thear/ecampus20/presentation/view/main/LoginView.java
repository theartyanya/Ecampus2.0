package com.example.thear.ecampus20.presentation.view.main;

import com.arellomobile.mvp.MvpView;

public interface LoginView extends MvpView {
    void showLoginError(String string);

    void showPasswordError(String string);

    void onLoggedIn();

    void showProgressDialog();

    void hideProgressDialog();
}
