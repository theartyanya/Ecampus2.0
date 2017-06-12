package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.DisciplineFilterView;
import com.example.thear.ecampus20.ui.activity.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class DisciplineFilterPresenter extends MvpPresenter<DisciplineFilterView> {
    @Inject
    Router router;

    public DisciplineFilterPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void showDisciplines() {
        router.navigateTo(Screens.DISCIPLINE_SCREEN);
    }
}
