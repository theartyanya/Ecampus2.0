package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.commons.Utils;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.ReviewDcchoicePresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.ReviewDcchoiceView;
import com.fondesa.recyclerviewdivider.RecyclerViewDivider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewDCCHoiceFragment extends MvpAppCompatFragment implements ReviewDcchoiceView {

    public static final String TAG = "ReviewDCCHoiceFragment";

    @InjectPresenter
    ReviewDcchoicePresenter mReviewDcchoicePresenter;
    @BindView(R.id.reviewDcChoiceRecyclerView)
    RecyclerView recyclerView;
    private Semestr semestr;
    private ReviewDCAdapter adapter;

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
        adapter = new ReviewDCAdapter(semestr.getBlocks(), getContext());
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

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setupTitle() {
        MvpAppCompatActivity activity = (MvpAppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(R.string.chosen_disc);
    }

    /*private class DiscArrayAdapter extends ArrayAdapter<Block> {

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
    }*/
}
