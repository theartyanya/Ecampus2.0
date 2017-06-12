package com.example.thear.ecampus20.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.ModuleChoicePresenter;
import com.example.thear.ecampus20.presentation.view.ModuleChoiceView;
import com.example.thear.ecampus20.ui.activity.Screens;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceFragment extends MvpAppCompatFragment implements ModuleChoiceView {
    @InjectPresenter
    ModuleChoicePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.module_choice, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.button_np)
    void moveToNp() {
        presenter.moveTo(Screens.NP_FILTER);
    }

    @OnClick(R.id.button_rnp)
    void moveToRnp() {
        presenter.moveTo(Screens.RNP_FILTER);
    }
}
