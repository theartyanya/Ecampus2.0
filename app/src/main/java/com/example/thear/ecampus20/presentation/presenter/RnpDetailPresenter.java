package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.RnpDetailView;

@InjectViewState
public class RnpDetailPresenter extends MvpPresenter<RnpDetailView> {
    public RnpDetailPresenter() {
        CampusApplication.getComponent().inject(this);
    }
}
