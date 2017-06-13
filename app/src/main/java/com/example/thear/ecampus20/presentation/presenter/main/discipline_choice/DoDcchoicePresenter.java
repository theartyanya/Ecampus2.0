package com.example.thear.ecampus20.presentation.presenter.main.discipline_choice;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DoDcchoiceView;
import com.example.thear.ecampus20.ui.activity.main.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class DoDcchoicePresenter extends MvpPresenter<DoDcchoiceView> {
    @Inject
    Router router;

    public DoDcchoicePresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void sendSubmitRequest() {
        goBack();
    }

    private void goBack() {
        router.backTo(Screens.DISCIPLINE_CHOICE_SCREEN);
    }
}
