package com.example.thear.ecampus20.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.ModuleChoiceView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ModuleChoicePresenter extends MvpPresenter<ModuleChoiceView> {
    @Inject
    Router router;

    public ModuleChoicePresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void moveTo(String screen) {
        router.navigateTo(screen);
    }
}
