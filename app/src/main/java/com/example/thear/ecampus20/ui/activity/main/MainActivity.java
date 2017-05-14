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
import com.example.thear.ecampus20.presentation.presenter.main.MainPresenter;
import com.example.thear.ecampus20.presentation.view.main.MainView;
import com.example.thear.ecampus20.ui.fragment.main.BulletinsFragment;
import com.example.thear.ecampus20.ui.fragment.main.DisciplineChoiceFragment;
import com.example.thear.ecampus20.ui.fragment.main.LoginFragment;
import com.example.thear.ecampus20.ui.fragment.main.RNPFragment;
import com.example.thear.ecampus20.ui.fragment.main.SplashFragment;
import com.example.thear.ecampus20.ui.fragment.main.StartFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public static final String TAG = "MainActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.navView)
    NavigationView nvDrawer;
    @Inject
    Router router;
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
        Utils.initializeStatusBar(this);
        ButterKnife.bind(this);
        setupDrawerContent();
        initializeToolbar();
        mMainPresenter.loadInitialFragment();
    }

    @Override
    public void loginMode() {
        toolbar.setVisibility(View.GONE);
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void initializeToolbar() {
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
                mMainPresenter.loadFragment(Screens.START_SCREEN);
                break;
            }
            case R.id.navBulletins: {
                mMainPresenter.loadFragment(Screens.BULLETINS_SCREEN);
                break;
            }
            case R.id.navDisciplineChoice: {
                mMainPresenter.loadFragment(Screens.DISCIPLINE_CHOICE_SCREEN);
                break;
            }
            case R.id.navRNP: {
                mMainPresenter.loadFragment(Screens.RNP_SCREEN);
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
}
