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
import com.example.thear.ecampus20.presentation.presenter.NpFilterPresenter;
import com.example.thear.ecampus20.presentation.view.NpFilterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NpFilterFragment extends MvpAppCompatFragment implements NpFilterView {
    @InjectPresenter
    NpFilterPresenter mPresenter;
    @BindView(R.id.faculty)
    Spinner mFacultySpinner;
    @BindView(R.id.cathedra)
    Spinner mCathedraSpinner;
    @BindView(R.id.specialty)
    Spinner mSpecialtySpinner;
    @BindView(R.id.specialization)
    Spinner mSpecializationSpinner;
    @BindView(R.id.study_year)
    Spinner mStudyYearSpinner;
    @BindView(R.id.okr)
    Spinner mOkrSpinner;
    @BindView(R.id.study_form)
    Spinner mStudyFormSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.np_filter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        setupNavigation();

        List<String> faculties = new ArrayList<>();
        faculties.add("Оберіть факультет");
        ArrayAdapter<String> facultyAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, faculties);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mFacultySpinner.setAdapter(facultyAdapter);

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
    }

    @OnClick(R.id.filters_selected_button)
    void onFiltersSelected() {
        mPresenter.moveToNpList();
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
