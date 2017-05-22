package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

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
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.ReviewDcchoicePresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.ReviewDcchoiceView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewDCCHoiceFragment extends MvpAppCompatFragment implements ReviewDcchoiceView {

    public static final String TAG = "ReviewDCCHoiceFragment";

    @InjectPresenter
    ReviewDcchoicePresenter mReviewDcchoicePresenter;
    @BindView(R.id.reviewDcChoiceListView)
    ListView listView;
    private Semestr semestr;

    public static ReviewDCCHoiceFragment newInstance(Semestr semestr) {
        ReviewDCCHoiceFragment fragment = new ReviewDCCHoiceFragment();
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
        View view = inflater.inflate(R.layout.fragment_review_dcchoice, container, false);
        ButterKnife.bind(this, view);
        listView.setAdapter(new DiscArrayAdapter(getContext(), semestr.getBlocks()));
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private class DiscArrayAdapter extends ArrayAdapter<Block> {

        public DiscArrayAdapter(Context context, List<Block> blocks) {
            super(context, 0, blocks);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Block block = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.item_view_dc_choice, null);
            }
            TextView componentTextView = ButterKnife.findById(convertView, R.id.dcItemComponentTextView);
            componentTextView.setText(block.getComponent().getName());
            TextView blockTextView = ButterKnife.findById(convertView, R.id.dcItemBlockTextView);
            blockTextView.setText(block.getBlock().getName());
            TextView dcCountTextView = ButterKnife.findById(convertView, R.id.dcItemDcCountTextView);
            dcCountTextView.setText(String.valueOf(block.getDisciplineCount()));
            LinearLayout linearLayout = ButterKnife.findById(convertView, R.id.dcItemLinLayout);
            linearLayout.removeAllViews();
            for (BlockDisc b : block.getBlockDisc()) {
                TextView textView = new TextView(getContext());
                textView.setText(b.getNameUkr());
                linearLayout.addView(textView);
            }
            return convertView;
        }
    }
}
