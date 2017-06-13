package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.model.Block;
import com.example.thear.ecampus20.model.BlockDisc;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.DoDcchoicePresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DoDcchoiceView;
import com.fondesa.recyclerviewdivider.RecyclerViewDivider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoDCChoiceFragment extends MvpAppCompatFragment implements DoDcchoiceView {

    public static final String TAG = "DoDCChoiceFragment";

    @InjectPresenter
    DoDcchoicePresenter mDoDcchoicePresenter;
    @BindView(R.id.doDcChoiceRecyclerView)
    RecyclerView recyclerView;
    private Semestr semestr;
    private ChoiceDCAdapter adapter;

    public static DoDCChoiceFragment newInstance(Semestr semestr) {
        DoDCChoiceFragment fragment = new DoDCChoiceFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constants.DC_SEMESTER_KEY, semestr);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        if (getArguments() != null) {
            semestr = (Semestr) getArguments().getSerializable(Constants.DC_SEMESTER_KEY);
        }
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_do_dcchoice, container, false);
        ButterKnife.bind(this, view);
        adapter = new ChoiceDCAdapter(semestr.getBlocks(), getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewDivider.with(getContext())
                .asSpace()
                .size((int) Utils.convertDpToPixel(8, getContext()))
                .hideLastDivider()
                .build()
                .addTo(recyclerView);
        setupTitle();
        return view;
    }

    private void setupTitle() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(R.string.choose_disc);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_do_choice, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuDoChoiceAccept: {
                if (checkBlocks()) {
                    showDialog();
                    return true;
                } else {
                    Toast.makeText(getContext(), R.string.dc_error_msg, Toast.LENGTH_SHORT).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.dialog_dc_title)
                .setMessage(R.string.dialog_dc_message)
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private boolean checkBlocks() {
        for (Block b : semestr.getBlocks()) {
            boolean flag = false;
            for (BlockDisc dc : b.getBlockDisc()) {
                if (dc.isChecked()) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
