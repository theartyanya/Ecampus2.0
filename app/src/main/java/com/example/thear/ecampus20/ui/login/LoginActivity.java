package com.example.thear.ecampus20.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.ui.login.splash.SplashFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadInitialFragment();
    }

    private void loadInitialFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginContentLayout, SplashFragment.newInstance())
                .commit();
    }
}
