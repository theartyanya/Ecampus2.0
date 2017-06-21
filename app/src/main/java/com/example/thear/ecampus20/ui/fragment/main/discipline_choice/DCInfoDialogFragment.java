package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thear.ecampus20.R;

/**
 * Created by aleks on 12.06.2017.
 */

public class DCInfoDialogFragment extends DialogFragment {
    public static DCInfoDialogFragment newInstance() {
        Bundle args = new Bundle();
        DCInfoDialogFragment fragment = new DCInfoDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_dc_info, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().setTitle(R.string.dc_info_title);
    }
}
