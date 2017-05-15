package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.model.Course;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.DisciplineSemestrPresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DisciplineSemestrView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisciplineSemestrFragment extends MvpAppCompatFragment implements DisciplineSemestrView {

    public static final String TAG = "DisciplineSemestrFragment";

    @InjectPresenter
    DisciplineSemestrPresenter mDisciplineSemestrPresenter;
    @BindView(R.id.dcLinearLayout)
    LinearLayout linearLayout;

    private Course course;

    public static DisciplineSemestrFragment newInstance(Course course) {
        DisciplineSemestrFragment fragment = new DisciplineSemestrFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constants.DC_COURSE_KEY, course);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            course = (Course) getArguments().getSerializable(Constants.DC_COURSE_KEY);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discipline_semestr, container, false);
        ButterKnife.bind(this, view);
        loadSemesters();
        return view;
    }

    private void loadSemesters() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (Semestr semestr : course.getSemestrs()) {
            View view = inflater.inflate(R.layout.semestr_layout, null);
            TextView studyYearTextView = ButterKnife.findById(view, R.id.semestrStudyYearTextView);
            studyYearTextView.setText(String.valueOf(semestr.getStudyPeriod().getStart())
                    .concat("-")
                    .concat(String.valueOf(semestr.getStudyPeriod().getEnd())));
            TextView studySemestrTextView = ButterKnife.findById(view, R.id.semestrStudySemestrTextView);
            studySemestrTextView.setText(String.valueOf(semestr.getSemester()));
            TextView studyStatustextView = ButterKnife.findById(view, R.id.semestrStudyStatusTextView);
            String statusString = "";
            switch (semestr.getStatus()) {
                case Constants.DC_STATUS_AVAILABLE: {
                    statusString = getString(R.string.dc_status_available);
                    break;
                }
                case Constants.DC_STATUS_UNAVAILABLE: {
                    statusString = getString(R.string.dc_status_unavailable);
                    break;
                }
                case Constants.DC_STATUS_DONE: {
                    statusString = getString(R.string.dc_status_done);
                    break;
                }
            }
            studyStatustextView.setText(statusString);
            linearLayout.addView(view);
        }
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
