package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.DisciplineChoicePresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DisciplineChoiceView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisciplineChoiceFragment extends MvpAppCompatFragment implements DisciplineChoiceView {

    public static final String TAG = "DisciplineChoiceFragment";

    @InjectPresenter
    DisciplineChoicePresenter mDisciplineChoicePresenter;
    @BindView(R.id.disciplineChoiceProgressBar)
    ProgressBar progressBar;
    @BindView(R.id.disciplineChoiceViewPager)
    ViewPager viewPager;
    private TabLayout tabLayout;

    public static DisciplineChoiceFragment newInstance() {
        DisciplineChoiceFragment fragment = new DisciplineChoiceFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discipline_choice, container, false);
        setHasOptionsMenu(true);
        ButterKnife.bind(this, view);
        tabLayout = ButterKnife.findById(getActivity(), R.id.tabLayout);
        setupNavigation();
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_discipline, menu);
    }

    private void setupNavigation() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.nav_discipline_choice));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navDisciplineChoice);
        menuItem.setChecked(true);
    }

    @Override
    public void showProgressBar() {
        viewPager.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        viewPager.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        tabLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void initializeViewPager(List<Semestr> list) {
        viewPager.setAdapter(new SemestrFragmentPagerAdapter(getChildFragmentManager(), list, getContext()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tabLayout.setVisibility(View.GONE);
    }
}
