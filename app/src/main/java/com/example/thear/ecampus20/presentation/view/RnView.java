package com.example.thear.ecampus20.presentation.view;

import android.app.Activity;

import com.arellomobile.mvp.MvpView;

public interface RnView extends MvpView {
    void updateView();
    void showToast(String msg);
    void mapFragment();
    void unmapFragment();
}
