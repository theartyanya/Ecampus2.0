package com.example.thear.ecampus20.presentation.presenter.main.discipline_choice;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.ReviewDcchoiceView;
import com.example.thear.ecampus20.ui.activity.main.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ReviewDcchoicePresenter extends MvpPresenter<ReviewDcchoiceView> {
    @Inject
    Router router;

    public ReviewDcchoicePresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void goToInfo() {
        router.navigateTo(Screens.VIEW_DC_INFO);
    }

}
