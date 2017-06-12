package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.DisciplineView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class DisciplinePresenter extends MvpPresenter<DisciplineView> {
    @Inject
    Router router;

    public DisciplinePresenter() {
        CampusApplication.getComponent().inject(this);
    }
}
