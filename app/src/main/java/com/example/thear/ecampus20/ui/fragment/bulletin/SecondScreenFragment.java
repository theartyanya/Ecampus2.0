package com.example.thear.ecampus20.ui.fragment.bulletin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.view.bulletins.BulletinsSecondScreenView;

public class SecondScreenFragment extends MvpAppCompatFragment implements BulletinsSecondScreenView {
    private static final String TAG = "second screen";

    public static SecondScreenFragment newInstance() {
        SecondScreenFragment fragment = new SecondScreenFragment();
        Bundle args = new Bundle();
        args.putString(TAG, "second");
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bulletin_tab2, container, false);
        return view;
    }
}
