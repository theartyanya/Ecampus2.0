package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.NpFilterView;
import com.example.thear.ecampus20.ui.activity.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class NpFilterPresenter extends MvpPresenter<NpFilterView> {
    @Inject
    Router router;

    public NpFilterPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void moveToNpList() {
        router.navigateTo(Screens.RNP_SCREEN);
    }
}
