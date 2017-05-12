package com.example.thear.ecampus20.blank.ui.main.discipline_choice;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.thear.ecampus20.R;

public class DisciplineChoiceFragment extends Fragment {

    public DisciplineChoiceFragment() {
        // Required empty public constructor
    }


    public static DisciplineChoiceFragment newInstance() {
        DisciplineChoiceFragment fragment = new DisciplineChoiceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discipline_choice, container, false);
        setupNavigation();
        return view;
    }

    private void setupNavigation() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.nav_discipline_choice));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navDisciplineChoice);
        menuItem.setChecked(true);
    }

}
