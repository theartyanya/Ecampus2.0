package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.CreditFilterView;
import com.example.thear.ecampus20.ui.activity.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class CreditFilterPresenter extends MvpPresenter<CreditFilterView> {
    @Inject
    Router router;

    public CreditFilterPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void showCredits() {
        router.navigateTo(Screens.CREDIT_SCREEN);
    }
}
