package com.example.thear.ecampus20.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.main.DcinfoPresenter;
import com.example.thear.ecampus20.presentation.view.main.DcinfoView;

public class DCInfoFragment extends MvpAppCompatFragment implements DcinfoView {
    public static final String TAG = "DCInfoFragment";
    @InjectPresenter
    DcinfoPresenter mDcinfoPresenter;

    public static DCInfoFragment newInstance() {
        DCInfoFragment fragment = new DCInfoFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dcinfo, container, false);
        setupTitle();
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setupTitle() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(R.string.dc_info_title);
    }
}
