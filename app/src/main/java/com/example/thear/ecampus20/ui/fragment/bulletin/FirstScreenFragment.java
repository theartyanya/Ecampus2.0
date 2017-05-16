package com.example.thear.ecampus20.ui.fragment.bulletin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.view.bulletins.BulletinsFirstScreenView;

public class FirstScreenFragment extends MvpAppCompatFragment implements BulletinsFirstScreenView {
    private static final String TAG = "first screen";

    public static FirstScreenFragment newInstance() {
        FirstScreenFragment fragment = new FirstScreenFragment();
        Bundle args = new Bundle();
        args.putString(TAG, "first");
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bulletin_tab1, container, false);
        return view;
    }
}
