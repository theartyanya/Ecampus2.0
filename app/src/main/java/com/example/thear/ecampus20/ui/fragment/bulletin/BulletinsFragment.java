package com.example.thear.ecampus20.ui.fragment.bulletin;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.bulletins.BulletinsPresenter;
import com.example.thear.ecampus20.presentation.view.bulletins.BulletinsView;
import com.example.thear.ecampus20.ui.adapter.BulletinSectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BulletinsFragment extends MvpAppCompatFragment implements BulletinsView {
    public static final String TAG = "BulletinsFragment";
    @InjectPresenter
    BulletinsPresenter mBulletinsPresenter;
    @BindView(R.id.bulletins_view_pager)
    ViewPager mViewPager;
    @BindView(R.id.bulletins_tab)
    TabLayout mTabLayout;

    public static BulletinsFragment newInstance() {
        BulletinsFragment fragment = new BulletinsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bulletins, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupNavigation();
        BulletinSectionsPagerAdapter mAdapter = new BulletinSectionsPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupNavigation() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.nav_bulletins));
        NavigationView navView = (NavigationView) activity.findViewById(R.id.navView);
        Menu navMenu = navView.getMenu();
        MenuItem menuItem = navMenu.findItem(R.id.navBulletins);
        menuItem.setChecked(true);
    }
}
