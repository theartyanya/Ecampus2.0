package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.DisciplineSemestrPresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DisciplineSemestrView;

public class DisciplineSemestrFragment extends MvpAppCompatFragment implements DisciplineSemestrView {
    public static final String TAG = "DisciplineSemestrFragment";
    @InjectPresenter
    DisciplineSemestrPresenter mDisciplineSemestrPresenter;

    public static DisciplineSemestrFragment newInstance() {
        DisciplineSemestrFragment fragment = new DisciplineSemestrFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discipline_semestr, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
