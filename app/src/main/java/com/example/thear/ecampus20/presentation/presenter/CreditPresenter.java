package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.CreditView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class CreditPresenter extends MvpPresenter<CreditView>{
    @Inject
    Router router;

    public CreditPresenter() {
        CampusApplication.getComponent().inject(this);
    }
}
