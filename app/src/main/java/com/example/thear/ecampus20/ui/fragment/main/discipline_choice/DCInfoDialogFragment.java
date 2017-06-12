package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(R.string.dc_info_title);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return alertDialogBuilder.create();
    }
}
