package com.example.thear.ecampus20.presentation.view.main.discipline_choice;

import com.arellomobile.mvp.MvpView;
import com.example.thear.ecampus20.model.Semestr;

import java.util.List;

public interface DisciplineChoiceView extends MvpView {
    void showProgressBar();

    void hideProgressBar();

    void initializeViewPager(List<Semestr> list);
}
