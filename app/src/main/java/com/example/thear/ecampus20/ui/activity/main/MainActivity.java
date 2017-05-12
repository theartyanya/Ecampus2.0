package com.example.thear.ecampus20.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.thear.ecampus20.CampusApplication;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.presentation.presenter.main.MainPresenter;
import com.example.thear.ecampus20.presentation.view.main.MainView;
import com.example.thear.ecampus20.ui.fragment.main.BulletinsFragment;
import com.example.thear.ecampus20.ui.fragment.main.DisciplineChoiceFragment;
import com.example.thear.ecampus20.ui.fragment.main.RNPFragment;
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
                case MainScreens.START_SCREEN: {
                    return StartFragment.newInstance();
                }
                case MainScreens.BULLETINS_SCREEN: {
                    return BulletinsFragment.newInstance();
                }
                case MainScreens.DISCIPLINE_CHOICE_SCREEN: {
                    return DisciplineChoiceFragment.newInstance();
                }
                case MainScreens.RNP_SCREEN: {
                    return RNPFragment.newInstance();
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

    public static Intent getIntent(final Context context) {

        return new Intent(context, MainActivity.class);
    }

    @ProvidePresenter
    public MainPresenter createPresenter() {
        return new MainPresenter(router);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CampusApplication.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.initializeStatusBar(this);
        ButterKnife.bind(this);
        setupDrawerContent();
        initializeToolbar();
        mMainPresenter.loadFragment(MainScreens.START_SCREEN);
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
                mMainPresenter.loadFragment(MainScreens.START_SCREEN);
                break;
            }
            case R.id.navBulletins: {

                break;
            }
            case R.id.navDisciplineChoice: {

                break;
            }
            case R.id.navRNP: {

                break;
            }
            case R.id.navExit: {

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

}
