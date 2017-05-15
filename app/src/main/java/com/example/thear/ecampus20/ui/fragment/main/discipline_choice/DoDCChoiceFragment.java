package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.commons.Constants;
import com.example.thear.ecampus20.model.Semestr;
import com.example.thear.ecampus20.presentation.presenter.main.discipline_choice.DoDcchoicePresenter;
import com.example.thear.ecampus20.presentation.view.main.discipline_choice.DoDcchoiceView;

public class DoDCChoiceFragment extends MvpAppCompatFragment implements DoDcchoiceView {
    public static final String TAG = "DoDCChoiceFragment";
    @InjectPresenter
    DoDcchoicePresenter mDoDcchoicePresenter;

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
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
