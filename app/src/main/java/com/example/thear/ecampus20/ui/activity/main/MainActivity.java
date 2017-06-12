package com.example.thear.ecampus20.ui.activity.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.main.MainPresenter;
import com.example.thear.ecampus20.presentation.view.main.MainView;
import com.example.thear.ecampus20.ui.fragment.main.BulletinsFragment;
import com.example.thear.ecampus20.ui.fragment.main.LoginFragment;
import com.example.thear.ecampus20.ui.fragment.main.ProfileFragment;
import com.example.thear.ecampus20.ui.fragment.main.RNPFragment;
import com.example.thear.ecampus20.ui.fragment.main.SplashFragment;
import com.example.thear.ecampus20.ui.fragment.main.StartFragment;
import com.example.thear.ecampus20.ui.fragment.main.discipline_choice.DisciplineChoiceFragment;
import com.example.thear.ecampus20.ui.fragment.main.discipline_choice.DoDCChoiceFragment;
import com.example.thear.ecampus20.ui.fragment.main.discipline_choice.ReviewDCCHoiceFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView, View.OnClickListener {

    public static final String TAG = "MainActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.navView)
    NavigationView nvDrawer;

    @InjectPresenter
    MainPresenter mMainPresenter;
    @Inject
    NavigatorHolder navigatorHolder;

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.mainContentLayout) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.START_SCREEN: {
                    return StartFragment.newInstance();
                }
                case Screens.BULLETINS_SCREEN: {
                    return BulletinsFragment.newInstance();
                }
                case Screens.DISCIPLINE_CHOICE_SCREEN: {
                    return DisciplineChoiceFragment.newInstance();
                }
                case Screens.RNP_SCREEN: {
                    return RNPFragment.newInstance();
                }
                case Screens.SPLASH_SCREEN: {
                    return SplashFragment.newInstance();
                }
                case Screens.LOGIN_SCREEN: {
                    return LoginFragment.newInstance();
                }
                case Screens.DO_CHOICE_SCREEN: {
                    return DoDCChoiceFragment.newInstance((Semestr) data);
                }
                case Screens.VIEW_CHOICE_SCREEN: {
                    return ReviewDCCHoiceFragment.newInstance((Semestr) data);
                }
                case Screens.PROFILE: {
                    return ProfileFragment.newInstance();
                }
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CampusApplication.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Utils.initializeStatusBar(this);
        initializeToolbar();
        setupDrawerContent();
        mMainPresenter.getMode();
        nvDrawer.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.loadMenuFragment(Screens.PROFILE);
            }
        });
    }

    @Override
    public void loginMode() {
        toolbar.setVisibility(View.GONE);
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void normalMode() {
        toolbar.setVisibility(View.VISIBLE);
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public void initializeToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void setupDrawerContent() {
        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navStart: {
                mMainPresenter.goToMainFragment();
                break;
            }
            case R.id.navBulletins: {
                mMainPresenter.loadMenuFragment(Screens.BULLETINS_SCREEN);
                break;
            }
            case R.id.navDisciplineChoice: {
                mMainPresenter.loadMenuFragment(Screens.DISCIPLINE_CHOICE_SCREEN);
                break;
            }
            case R.id.navRNP: {
                mMainPresenter.loadMenuFragment(Screens.RNP_SCREEN);
                break;
            }
            case R.id.navExit: {
                mMainPresenter.exit();
                break;
            }
        }
        mDrawer.closeDrawers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                openDrawer();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void openDrawer() {
        mDrawer.openDrawer(Gravity.START);
    }

    @Override
    public void onClick(View v) {

    }
}
