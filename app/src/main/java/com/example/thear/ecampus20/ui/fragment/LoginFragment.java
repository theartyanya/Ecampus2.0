package com.example.thear.ecampus20.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.presentation.presenter.LoginPresenter;
import com.example.thear.ecampus20.presentation.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    public static final String TAG = "LoginFragment";

    @InjectPresenter
    LoginPresenter mLoginPresenter;
    @BindView(R.id.loginLoginTextInputLayout)
    TextInputLayout loginTextInputLayout;
    @BindView(R.id.loginPasswordTextInputLayout)
    TextInputLayout passwordTextInputLayout;
    @BindView(R.id.loginButton)
    Button loginButton;

    private ProgressDialog progressDialog;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Utils.setupUI(view, getActivity());
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginPresenter.validateLogin(s.toString());
            }
        });
        passwordTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginPresenter.validatePassword(s.toString());
            }
        });
    }

    @OnClick(R.id.loginButton)
    public void onLoginClicked() {
        mLoginPresenter.onLoginButtonClicked(
                loginTextInputLayout.getEditText().getText().toString(),
                passwordTextInputLayout.getEditText().getText().toString());
    }

    @Override
    public void showLoginError(String string) {
        loginTextInputLayout.setError(string);
    }

    @Override
    public void showPasswordError(String string) {
        passwordTextInputLayout.setError(string);
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
}
