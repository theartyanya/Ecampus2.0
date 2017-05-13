package com.example.thear.ecampus20.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.main.SplashPresenter;
import com.example.thear.ecampus20.presentation.view.main.SplashView;

public class SplashFragment extends MvpAppCompatFragment implements SplashView {
    public static final String TAG = "SplashFragment";
    @InjectPresenter
    SplashPresenter mSplashPresenter;

    public static SplashFragment newInstance() {
        SplashFragment fragment = new SplashFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
