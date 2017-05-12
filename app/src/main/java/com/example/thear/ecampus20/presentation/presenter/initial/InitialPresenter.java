package com.example.thear.ecampus20.presentation.presenter.initial;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.presentation.view.initial.InitialView;
import com.example.thear.ecampus20.ui.activity.initial.LoginScreens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by aleks on 12.05.2017.
 */
@InjectViewState
public class InitialPresenter extends MvpPresenter<InitialView> {

    @Inject
    SharedPreferences preferences;
    private Router router;

    public InitialPresenter(Router router) {
        this.router = router;
    }

    public void loadInitialFragment() {
        CampusApplication.getComponent().inject(this);
        String login = preferences.getString(Constants.SHARED_PREFERENCES_LOGIN_TAG, null);
        String password = preferences.getString(Constants.SHARED_PREFERENCES_PASS_TAG, null);
        if (login == null || password == null) {
            router.newRootScreen(LoginScreens.LOGIN_SCREEN);
        } else {
            router.newRootScreen(LoginScreens.SPLASH_SCREEN);
        }
    }
}
