package com.example.thear.ecampus20.ui.activity.initial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.presentation.presenter.initial.InitialPresenter;
import com.example.thear.ecampus20.presentation.view.initial.InitialView;
import com.example.thear.ecampus20.ui.fragment.initial.LoginFragment;
import com.example.thear.ecampus20.ui.fragment.initial.SplashFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class InitialActivity extends MvpAppCompatActivity implements InitialView {

    public static final String TAG = "InitialActivity";

    @Inject
    Router router;

    @InjectPresenter
    InitialPresenter mInitialPresenter;
    @Inject
    NavigatorHolder navigatorHolder;
    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.loginContentLayout) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case LoginScreens.SPLASH_SCREEN: {
                    return SplashFragment.newInstance();
                }
                case LoginScreens.LOGIN_SCREEN: {
                    return LoginFragment.newInstance();
                }
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(InitialActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    public static Intent getIntent(final Context context) {

        return new Intent(context, InitialActivity.class);
    }

    @ProvidePresenter
    public InitialPresenter createPresenter() {
        return new InitialPresenter(router);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CampusApplication.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils.initializeStatusBar(this);
        mInitialPresenter.loadInitialFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

}
