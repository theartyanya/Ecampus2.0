package com.example.thear.ecampus20.presentation.presenter.bulletins;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.bulletins.BulletinsView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class BulletinsPresenter extends MvpPresenter<BulletinsView> {
    @Inject
    Router router;

    public BulletinsPresenter() {
        CampusApplication.getComponent().inject(this);
    }
}
