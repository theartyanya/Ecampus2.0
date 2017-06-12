package com.example.thear.ecampus20.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.RnpFilterPresenter;
import com.example.thear.ecampus20.presentation.view.RnpFilterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RnpFilterFragment extends MvpAppCompatFragment implements RnpFilterView {
    @InjectPresenter
    RnpFilterPresenter presenter;
    @BindView(R.id.rnp_cathedra)
    Spinner mCathedraSpinner;
    @BindView(R.id.rnp_specialty)
    Spinner mSpecialtySpinner;
    @BindView(R.id.rnp_specialization)
    Spinner mSpecializationSpinner;
    @BindView(R.id.rnp_study_year)
    Spinner mStudyYearSpinner;
    @BindView(R.id.rnp_okr)
    Spinner mOkrSpinner;
    @BindView(R.id.rnp_study_form)
    Spinner mStudyFormSpinner;
    @BindView(R.id.rnp_course)
    Spinner mCourseSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rnp_filter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupNavigation();

        List<String> cathedras = new ArrayList<>();
        cathedras.add("Оберіть кафедру");
        ArrayAdapter<String> cathedraAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, cathedras);
        cathedraAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCathedraSpinner.setAdapter(cathedraAdapter);

        List<String> specialties = new ArrayList<>();
        specialties.add("Оберіть спеціальність");
        ArrayAdapter<String> specialityAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, specialties);
        specialityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpecialtySpinner.setAdapter(specialityAdapter);

        List<String> specializations = new ArrayList<>();
        specializations.add("Оберіть спеціалізацію");
        ArrayAdapter<String> specializationAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, specializations);
        specializationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpecializationSpinner.setAdapter(specializationAdapter);

        List<String> studyYears = new ArrayList<>();
        studyYears.add("Оберіть навчальний рік");
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, studyYears);
        yearsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStudyYearSpinner.setAdapter(yearsAdapter);

        List<String> okrs = new ArrayList<>();
        okrs.add("Оберіть ОКР");
        ArrayAdapter<String> okrsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, okrs);
        okrsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mOkrSpinner.setAdapter(okrsAdapter);

        List<String> forms = new ArrayList<>();
        forms.add("Оберіть форму навчання");
        ArrayAdapter<String> formAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, forms);
        formAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStudyFormSpinner.setAdapter(formAdapter);

        List<String> courses = new ArrayList<>();
        courses.add("Оберіть курс");
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, courses);
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourseSpinner.setAdapter(courseAdapter);
    }

    @OnClick(R.id.rnp_filters_selected_button)
    public void onRnpFiltersSelected() {
        presenter.showRnp();
    }

    private void setupNavigation() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.nav_rnp));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navRNP);
        menuItem.setChecked(true);
    }
}
