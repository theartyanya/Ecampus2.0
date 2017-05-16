package com.example.thear.ecampus20.ui.fragment.discipline_choice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.model.Block;
import com.example.thear.ecampus20.model.BlockDisc;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.discipline_choice.DoDcchoicePresenter;
import com.example.thear.ecampus20.presentation.view.discipline_choice.DoDcchoiceView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoDCChoiceFragment extends MvpAppCompatFragment implements DoDcchoiceView {

    public static final String TAG = "DoDCChoiceFragment";

    @InjectPresenter
    DoDcchoicePresenter mDoDcchoicePresenter;
    @BindView(R.id.doDcChoiceListView)
    ListView listView;
    private Semestr semestr;

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
        View view = inflater.inflate(R.layout.fragment_do_dcchoice, container, false);
        ButterKnife.bind(this, view);
        View footerView = LayoutInflater.from(getContext())
                .inflate(R.layout.footer_subjects, null);
        listView.addFooterView(footerView);
        listView.setAdapter(new DiscArrayAdapter(getContext(), semestr.getBlocks()));
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private class DiscArrayAdapter extends ArrayAdapter<Block> {

        public DiscArrayAdapter(Context context, List<Block> list) {
            super(context, 0, list);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Block block = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.item_do_dc_choice, null);
            }
            TextView componentTextView = ButterKnife.findById(convertView, R.id.dcItemComponentTextView);
            componentTextView.setText(block.getComponent().getName());
            TextView blockTextView = ButterKnife.findById(convertView, R.id.dcItemBlockTextView);
            blockTextView.setText(block.getBlock().getName());
            TextView dcCountTextView = ButterKnife.findById(convertView, R.id.dcItemDcCountTextView);
            dcCountTextView.setText(String.valueOf(block.getDisciplineCount()));
            LinearLayout layout = ButterKnife.findById(convertView, R.id.dcItemLinLayout);
            layout.removeAllViews();
            for (BlockDisc b : block.getBlockDisc()) {
                View view = LayoutInflater.from(getContext())
                        .inflate(R.layout.item_block_subject, null);
                TextView divisionTextView = ButterKnife.findById(view, R.id.dcSubjectDivisionTextView);
                divisionTextView.setText(b.getSubdivision());
                TextView nameTextView = ButterKnife.findById(view, R.id.dcSubjectNameTextView);
                nameTextView.setText(b.getNameUkr());
                TextView descTextView = ButterKnife.findById(view, R.id.dcSubjectDescTextView);
                descTextView.setText(b.getAnnotationEng());
                TextView maxStudentsTextView = ButterKnife.findById(view, R.id.dcSubjectMaxStudentsTextView);
                maxStudentsTextView.setText(String.valueOf(b.getMaxCountStudent()));
                TextView studentsTextView = ButterKnife.findById(view, R.id.dcSubjectStudentsTextView);
                studentsTextView.setText(String.valueOf(b.getStudentCount()));
                layout.addView(view);
            }
            return convertView;
        }
    }
}
