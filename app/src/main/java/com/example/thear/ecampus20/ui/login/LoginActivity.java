package com.example.thear.ecampus20.ui.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.ui.login.splash.SplashFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeStatusBar();
        loadInitialFragment();
    }

    private void loadInitialFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginContentLayout, SplashFragment.newInstance())
                .commit();
    }

    private void initializeStatusBar() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#20000000"));
    }
}
