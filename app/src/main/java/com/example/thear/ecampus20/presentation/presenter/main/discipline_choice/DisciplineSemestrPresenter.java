package com.example.thear.ecampus20.presentation.presenter.main.discipline_choice;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.model.Course;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DisciplineSemestrView;
import com.example.thear.ecampus20.ui.activity.main.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class DisciplineSemestrPresenter extends MvpPresenter<DisciplineSemestrView> {

    private static final String TAG = "DcSemestrPresenter";

    @Inject
    Router router;

    private Course course;

    public DisciplineSemestrPresenter() {
        CampusApplication.getComponent().inject(this);
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void goDoDiscChoice(long semestr) {
        Semestr chosenSemestr = null;
        for (Semestr s : course.getSemestrs()) {
            if (s.getSemester() == semestr) {
                chosenSemestr = s;
                break;
            }
        }
        if (chosenSemestr != null) {
            router.navigateTo(Screens.DO_CHOICE_SCREEN, chosenSemestr);
        }
    }
}
