package com.example.thear.ecampus20.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.presentation.presenter.SplashPresenter;
import com.example.thear.ecampus20.presentation.view.SplashView;

import butterknife.ButterKnife;

public class SplashFragment extends MvpAppCompatFragment implements SplashView {

    public static final String TAG = "SplashFragment";

    @InjectPresenter
    SplashPresenter mSplashPresenter;

    private ProgressDialog progressDialog;

    public static SplashFragment newInstance() {
        SplashFragment fragment = new SplashFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        mSplashPresenter.authUser();
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onLoggedIn() {
        Toolbar toolbar = ButterKnife.findById(getActivity(), R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        DrawerLayout drawerLayout = ButterKnife.findById(getActivity(), R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = Utils.createProgressDialog(getContext());
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void showError(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
