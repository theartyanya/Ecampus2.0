package com.example.thear.ecampus20.presentation.view;

import com.arellomobile.mvp.MvpView;

public interface SplashView extends MvpView {
    void onLoggedIn();

    void showProgressDialog();

    void hideProgressDialog();

    void showError(String s);
}
