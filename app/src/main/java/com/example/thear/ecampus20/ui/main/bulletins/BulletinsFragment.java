package com.example.thear.ecampus20.ui.main.bulletins;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thear.ecampus20.R;


public class BulletinsFragment extends Fragment {


    public BulletinsFragment() {
        // Required empty public constructor
    }

    public static BulletinsFragment newInstance() {
        BulletinsFragment fragment = new BulletinsFragment();
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
        return inflater.inflate(R.layout.fragment_bulletins, container, false);
    }

}
