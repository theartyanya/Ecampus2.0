package com.example.thear.ecampus20.ui.activity;

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
import com.example.thear.ecampus20.model.RnpModel;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.model.rnp.NpModel;
import com.example.thear.ecampus20.presentation.presenter.MainPresenter;
import com.example.thear.ecampus20.presentation.view.MainView;
import com.example.thear.ecampus20.ui.fragment.BulletinsFragment;
import com.example.thear.ecampus20.ui.fragment.LoginFragment;
import com.example.thear.ecampus20.ui.fragment.NpDetailFragment;
import com.example.thear.ecampus20.ui.fragment.NpFilterFragment;
import com.example.thear.ecampus20.ui.fragment.NpFragment;
import com.example.thear.ecampus20.ui.fragment.RnpDetailFragment;
import com.example.thear.ecampus20.ui.fragment.RnpFilterFragment;
import com.example.thear.ecampus20.ui.fragment.RnpFragment;
import com.example.thear.ecampus20.ui.fragment.SplashFragment;
import com.example.thear.ecampus20.ui.fragment.StartFragment;
import com.example.thear.ecampus20.ui.fragment.ChoiceFragment;
import com.example.thear.ecampus20.ui.fragment.discipline_choice.DisciplineChoiceFragment;
import com.example.thear.ecampus20.ui.fragment.discipline_choice.DoDCChoiceFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public static final String TAG = "MainActivity";
    Fragment npListFragment;

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
                case Screens.NP_SCREEN: {
                    return NpFragment.newInstance();
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
                case Screens.NP_FILTER:
                    return new NpFilterFragment();

                case Screens.NP_DETAILS: {
                    Fragment fragment = new NpDetailFragment();
                    Bundle args = new Bundle();
                    args.putString("Name", ((NpModel) data).getName());
                    args.putString("Actuality", ((NpModel) data).getActuality() ? "Актуально" : "Не актуально");
                    args.putString("Specialization", ((NpModel) data).getSpecialization().getName());
                    args.putString("StudyYear", ((NpModel) data).getStudyingYear().getName());
                    args.putString("StudyForm", ((NpModel) data).getStudyForm().getName());
                    args.putString("ChangeDate", ((NpModel) data).getChangeDate());
                    args.putString("Okr", ((NpModel) data).getOkr().getName());
                    if (((NpModel) data).getStudyTermYear() != null)
                        args.putInt("TermYear", ((NpModel) data).getStudyTermYear());
                    if (((NpModel) data).getStudyTermMonth() != null)
                        args.putInt("TermMonth", ((NpModel) data).getStudyTermMonth());
                    fragment.setArguments(args);
                    return fragment;
                }
                case Screens.NP_MODULES_SCREEN: {
                    return new ChoiceFragment();
                }
                case Screens.RNP_FILTER: {
                    return new RnpFilterFragment();
                }
                case Screens.RNP_SCREEN: {
                    return new RnpFragment();
                }
                case Screens.RNP_DETAILS: {
                    Fragment fragment = new RnpDetailFragment();
                    Bundle args = new Bundle();
                    args.putString("Name", ((RnpModel) data).getName());
                    args.putString("Actuality", ((RnpModel) data).getActuality() ? "Актуально" : "Не актуально");
                    args.putString("Specialization", ((RnpModel) data).getSpeciality());
                    args.putString("StudyYear", ((RnpModel) data).getYearRnp());
                    args.putString("StudyForm", ((RnpModel) data).getStudyForm());
                    args.putString("ChangeDate", ((RnpModel) data).getChangeDate());
                    args.putString("Okr", ((RnpModel) data).getOkr());
                    if (((RnpModel) data).getProtocolNumber() != null)
                        args.putString("Protocol", ((RnpModel) data).getProtocolNumber());
                    if (((RnpModel) data).getCourse() != null)
                        args.putInt("Course", ((RnpModel) data).getCourse());
                    fragment.setArguments(args);
                    return fragment;
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
                mMainPresenter.loadMenuFragment(Screens.NP_MODULES_SCREEN);
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

    public void setFragment(Fragment fragment) {
        npListFragment = fragment;
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && npListFragment != null && npListFragment instanceof NpFragment) {
            mMainPresenter.backToFilter();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}