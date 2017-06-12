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
import com.example.thear.ecampus20.presentation.presenter.DisciplineFilterPresenter;
import com.example.thear.ecampus20.presentation.view.DisciplineFilterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisciplineFilterFragment extends MvpAppCompatFragment implements DisciplineFilterView {
    @InjectPresenter
    DisciplineFilterPresenter mPresenter;
    @BindView(R.id.discipline_cathedra)
    Spinner mCathedraSpinner;
    @BindView(R.id.discipline_specialty)
    Spinner mSpecialtySpinner;
    @BindView(R.id.discipline_specialization)
    Spinner mSpecializationSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.discipline_filter, container, false);
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
    }

    private void setupNavigation() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.discipline_title));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navRNP);
        menuItem.setChecked(true);
    }
    
    @OnClick(R.id.discipline_filters_selected_button)
    void showDisciplines() {mPresenter.showDisciplines();}
}
