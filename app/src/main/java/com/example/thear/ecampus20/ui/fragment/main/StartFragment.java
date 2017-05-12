package com.example.thear.ecampus20.ui.fragment.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.main.StartPresenter;
import com.example.thear.ecampus20.presentation.view.main.StartView;

public class StartFragment extends MvpAppCompatFragment implements StartView {
    public static final String TAG = "StartFragment";
    @InjectPresenter
    StartPresenter mStartPresenter;

    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        setupNavigation();
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setupNavigation() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.nav_main));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navStart);
        menuItem.setChecked(true);
    }
}
