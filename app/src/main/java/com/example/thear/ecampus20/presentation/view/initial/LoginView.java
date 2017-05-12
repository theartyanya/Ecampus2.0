package com.example.thear.ecampus20.presentation.view.initial;

import com.arellomobile.mvp.MvpView;

public interface LoginView extends MvpView {
    void showLoginError(String string);

    void showPasswordError(String string);
}
