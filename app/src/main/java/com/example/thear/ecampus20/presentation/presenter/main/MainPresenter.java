package com.example.thear.ecampus20.presentation.presenter.main;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.presentation.view.main.MainView;
import com.example.thear.ecampus20.ui.activity.main.MainScreens;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private Router router;

    public MainPresenter(Router router) {
        this.router = router;
    }

    public void loadFragment(String screenName) {
        router.navigateTo(screenName);
    }

    public void exit() {
        router.finishChain();
    }

    public void returnToStart() {
        router.backTo(MainScreens.START_SCREEN);

    }
}
