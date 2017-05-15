package com.example.thear.ecampus20.presentation.presenter.main;


import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.presentation.view.main.MainView;
import com.example.thear.ecampus20.ui.activity.main.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    SharedPreferences preferences;

    @Inject
    Router router;

    public MainPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadInitialFragment();
    }

    public void loadFragment(String screenName) {
        router.navigateTo(screenName);
    }

    public void exit() {
        router.newRootScreen(Screens.LOGIN_SCREEN);
        clearSharedPreferences();
        getViewState().loginMode();
    }

    private void clearSharedPreferences() {
        preferences
                .edit()
                .remove(Constants.SHARED_PREFERENCES_LOGIN_TAG)
                .remove(Constants.SHARED_PREFERENCES_PASS_TAG)
                .apply();
    }

    public void returnToStart() {
        router.backTo(Screens.START_SCREEN);

    }

    public void loadInitialFragment() {
        String login = preferences.getString(Constants.SHARED_PREFERENCES_LOGIN_TAG, null);
        String password = preferences.getString(Constants.SHARED_PREFERENCES_PASS_TAG, null);
        if (login == null || password == null) {
            router.newRootScreen(Screens.LOGIN_SCREEN);
        } else {
            router.newRootScreen(Screens.SPLASH_SCREEN);
        }
    }

    public void getMode() {
        String login = preferences.getString(Constants.SHARED_PREFERENCES_LOGIN_TAG, null);
        String password = preferences.getString(Constants.SHARED_PREFERENCES_PASS_TAG, null);
        if (login == null || password == null) {
            getViewState().loginMode();
        } else {
            getViewState().normalMode();
        }
    }
}
