package com.example.thear.ecampus20.ui.login.splash;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.Utils;
import com.example.thear.ecampus20.ui.main.MainActivity;

public class SplashFragment extends Fragment {


    public SplashFragment() {
        // Required empty public constructor
    }

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        getUser();
        return view;
    }

    private void getUser() {
        Utils.startAnotherActivity((AppCompatActivity) getActivity(), MainActivity.class);
    }

}
