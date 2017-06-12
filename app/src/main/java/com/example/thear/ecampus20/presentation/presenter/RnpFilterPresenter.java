package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.RnpFilterView;
import com.example.thear.ecampus20.ui.activity.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class RnpFilterPresenter extends MvpPresenter<RnpFilterView> {
    @Inject
    Router router;

    public RnpFilterPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void showRnp() {
        router.navigateTo(Screens.RNP_SCREEN);
    }
}
