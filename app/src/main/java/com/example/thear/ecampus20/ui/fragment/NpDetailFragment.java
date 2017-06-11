package com.example.thear.ecampus20.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.NpDetailPresenter;
import com.example.thear.ecampus20.presentation.view.NpDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NpDetailFragment extends MvpAppCompatFragment implements NpDetailView {
    @InjectPresenter
    NpDetailPresenter mPresenter;
    @BindView(R.id.np_detail_name)
    TextView detail_name;
    @BindView(R.id.np_detail_actuality)
    TextView detail_actuality;
    @BindView(R.id.np_detail_specialization)
    TextView detail_specialization;
    @BindView(R.id.np_detail_study_year)
    TextView detail_study_year;
    @BindView(R.id.np_detail_study_form)
    TextView detail_study_form;
    @BindView(R.id.np_detail_date_change)
    TextView detail_date_change;
    @BindView(R.id.np_detail_okr)
    TextView detail_okr;
    @BindView(R.id.np_detail_term_year)
    TextView detail_term_year;
    @BindView(R.id.np_detail_term_month)
    TextView detail_term_month;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.np_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        detail_name.setText(this.getArguments().getString("Name"));
        detail_actuality.setText(this.getArguments().getString("Actuality"));
        detail_specialization.setText(this.getArguments().getString("Specialization"));
        detail_study_year.setText(this.getArguments().getString("StudyYear"));
        detail_study_form.setText(this.getArguments().getString("StudyForm"));
        detail_date_change.setText(this.getArguments().getString("ChangeDate"));
        detail_okr.setText(this.getArguments().getString("Okr"));
        if (this.getArguments().containsKey("TermYear")) {
            detail_term_year.setText(String.valueOf(this.getArguments().getInt("TermYear")));
        } else {
            detail_term_year.setText(R.string.no_value);
        }
        if (this.getArguments().containsKey("TermMonth")) {
            detail_term_month.setText(String.valueOf(this.getArguments().getInt("TermMonth")));
        } else {
            detail_term_month.setText(R.string.no_value);
        }
    }
}

