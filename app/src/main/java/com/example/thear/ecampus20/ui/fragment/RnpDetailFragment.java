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
import com.example.thear.ecampus20.presentation.presenter.RnpDetailPresenter;
import com.example.thear.ecampus20.presentation.view.RnpDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RnpDetailFragment extends MvpAppCompatFragment implements RnpDetailView {
    @InjectPresenter
    RnpDetailPresenter mPresenter;
    @BindView(R.id.rnp_detail_name)
    TextView detail_name;
    @BindView(R.id.rnp_detail_actuality)
    TextView detail_actuality;
    @BindView(R.id.rnp_detail_specialization)
    TextView detail_specialization;
    @BindView(R.id.rnp_detail_study_year)
    TextView detail_study_year;
    @BindView(R.id.rnp_detail_study_form)
    TextView detail_study_form;
    @BindView(R.id.rnp_detail_date_change)
    TextView detail_date_change;
    @BindView(R.id.rnp_detail_okr)
    TextView detail_okr;
    @BindView(R.id.rnp_detail_course)
    TextView detail_course;
    @BindView(R.id.rnp_detail_protocol)
    TextView detail_protocol;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rnp_detail_fragment, container, false);
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
        if (this.getArguments().containsKey("Protocol")) {
            detail_protocol.setText(String.valueOf(this.getArguments().getString("Protocol")));
        } else {
            detail_protocol.setText(R.string.no_value);
        }
        if (this.getArguments().containsKey("Course")) {
            detail_course.setText(String.valueOf(this.getArguments().getInt("Course")));
        } else {
            detail_course.setText(R.string.no_value);
        }
    }
}
