package com.example.thear.ecampus20.ui.login.login;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.Utils;
import com.example.thear.ecampus20.ui.main.MainActivity;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "login_fragment";

    private TextInputLayout loginTextInputLayout;
    private TextInputLayout passwordTextInputLayout;
    private Button button;
    private boolean isLoginClicked = false;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initializeViews(view);
        Utils.setupUI(view, (AppCompatActivity) getActivity());
        return view;
    }

    private void initializeViews(View view) {
        loginTextInputLayout = (TextInputLayout) view.findViewById(R.id.loginLoginTextInputLayout);
        passwordTextInputLayout = (TextInputLayout) view.findViewById(R.id.loginPasswordTextInputLayout);
        button = (Button) view.findViewById(R.id.loginButton);
        button.setOnClickListener(this);
        new MyTextWatcher(loginTextInputLayout);
        new MyTextWatcher(passwordTextInputLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton: {
                login();
                break;
            }
        }
    }

    private void login() {
        isLoginClicked = true;
        if (validateForm()) {
            sendLoginRequest();
        }
    }

    private void sendLoginRequest() {
        Utils.startAnotherActivity((AppCompatActivity) getActivity(), MainActivity.class);
    }

    private boolean validateForm() {
        return checkTextInput(loginTextInputLayout) &
                checkTextInput(passwordTextInputLayout);
    }

    private boolean checkTextInput(TextInputLayout textInputLayout) {
        if (TextUtils.isEmpty(textInputLayout.getEditText().getText())) {
            textInputLayout.setError(getString(R.string.error_text));
            return false;
        }
        textInputLayout.setError(null);
        return true;
    }

    class MyTextWatcher implements TextWatcher {

        private TextInputLayout textInputLayout;

        MyTextWatcher(TextInputLayout textInputLayout) {
            this.textInputLayout = textInputLayout;
            this.textInputLayout.getEditText().addTextChangedListener(this);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (isLoginClicked) {
                checkTextInput(textInputLayout);
            }
        }
    }
}
