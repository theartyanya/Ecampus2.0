package com.example.thear.ecampus20.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.thear.ecampus20.ui.fragment.bulletin.FirstScreenFragment;
import com.example.thear.ecampus20.ui.fragment.bulletin.SecondScreenFragment;
import com.example.thear.ecampus20.ui.fragment.bulletin.ThirdScreenFragment;

public class BulletinSectionsPagerAdapter extends FragmentPagerAdapter {

    public BulletinSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
            case 0:
                return FirstScreenFragment.newInstance();
            case 1:
                return SecondScreenFragment.newInstance();
            case 2:
                return ThirdScreenFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "First";
            case 1:
                return "Second";
            case 2:
                return "Third";
        }
    }
}
