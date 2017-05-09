package com.example.thear.ecampus20.ui.main;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.thear.ecampus20.Constants;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.ui.main.bulletins.BulletinsFragment;
import com.example.thear.ecampus20.ui.main.discipline_choice.DisciplineChoiceFragment;
import com.example.thear.ecampus20.ui.main.main.MainFragment;
import com.example.thear.ecampus20.ui.main.rnp.RNPFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main_activity";

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initializeAppbar();
        initializeDrawer();
        initializeStatusBar();
        loadInitialFragment();
    }

    private void loadInitialFragment() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.mainContentLayout, MainFragment.newInstance())
                .addToBackStack(Constants.MAIN_TAG)
                .commit();
    }

    private void initializeDrawer() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.navView);
        setupDrawerContent(nvDrawer);
    }

    private void initializeAppbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void initializeStatusBar() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#20000000"));
    }

    private void setupDrawerContent(NavigationView nvDrawer) {
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
        Fragment fragment = null;
        Class fragmentClass = null;
        String string = null;
        switch (menuItem.getItemId()) {
            case R.id.navMain: {
                fragmentClass = MainFragment.class;
                string = Constants.MAIN_TAG;
                break;
            }
            case R.id.navBulletins: {
                fragmentClass = BulletinsFragment.class;
                string = Constants.BULLETINS_TAG;
                break;
            }
            case R.id.navDisciplineChoice: {
                fragmentClass = DisciplineChoiceFragment.class;
                string = Constants.DISCIPLINE_CHOICE_TAG;
                break;
            }
            case R.id.navRNP: {
                fragmentClass = RNPFragment.class;
                string = Constants.RNP_TAG;
                break;
            }
            case R.id.navExit: {
                exit();
                break;
            }
        }
        if (fragmentClass != null) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.mainContentLayout, fragment)
                        .addToBackStack(string)
                        .commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mDrawer.closeDrawers();
    }

    private void exit() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        int i = fragmentManager.getBackStackEntryCount();
        String tag = fragmentManager.getBackStackEntryAt(i - 1).getName();
        switch (tag) {
            case Constants.MAIN_TAG: {
                finish();
                break;
            }
            default: {
                fragmentManager.popBackStackImmediate(Constants.MAIN_TAG, 0);
                break;
            }
        }
    }
}
