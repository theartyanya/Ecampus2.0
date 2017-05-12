package com.example.thear.ecampus20.ui.fragment.initial;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
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
import com.example.thear.ecampus20.presentation.presenter.initial.LoginPresenter;
import com.example.thear.ecampus20.presentation.view.initial.LoginView;

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
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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


}
