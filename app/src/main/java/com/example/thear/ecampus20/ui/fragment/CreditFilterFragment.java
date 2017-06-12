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
import com.example.thear.ecampus20.presentation.presenter.CreditFilterPresenter;
import com.example.thear.ecampus20.presentation.view.CreditFilterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditFilterFragment extends MvpAppCompatFragment implements CreditFilterView {
    @InjectPresenter
    CreditFilterPresenter mPresenter;
    @BindView(R.id.credit_cathedra)
    Spinner mCathedraSpinner;
    @BindView(R.id.credit_specialty)
    Spinner mSpecialtySpinner;
    @BindView(R.id.credit_specialization)
    Spinner mSpecializationSpinner;
    @BindView(R.id.credit_discipline)
    Spinner mDisciplineSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.credit_filter, container, false);
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

        List<String> disciplines = new ArrayList<>();
        disciplines.add("Оберіть дисципліну");
        ArrayAdapter<String> disciplineAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, disciplines);
        disciplineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDisciplineSpinner.setAdapter(disciplineAdapter);
    }

    private void setupNavigation() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.credit_title));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navRNP);
        menuItem.setChecked(true);
    }

    @OnClick(R.id.credit_filters_selected_button)
    void showCredits() {
        mPresenter.showCredits();
    }
}
