package com.example.thear.ecampus20.ui.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.presentation.presenter.ModuleChoicePresenter;
import com.example.thear.ecampus20.presentation.view.ModuleChoiceView;
import com.example.thear.ecampus20.ui.activity.Screens;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceFragment extends MvpAppCompatFragment implements ModuleChoiceView {
    @InjectPresenter
    ModuleChoicePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.module_choice, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.button_np)
    void moveToNp() {
        presenter.moveTo(Screens.NP_FILTER);
    }

    @OnClick(R.id.button_rnp)
    void moveToRnp() {
        presenter.moveTo(Screens.RNP_FILTER);
    }

    @OnClick(R.id.button_discipline)
    void moveToDisciplines() {presenter.moveTo(Screens.DISCIPLINE_FILTER);}

    @OnClick(R.id.button_credit)
    void moveToCredits() {presenter.moveTo(Screens.CREDIT_FILTER);}

    @OnClick(R.id.btn_popup)
    void displayPopupWindow(View anchorView) {
        PopupWindow popup = new PopupWindow(getContext());
        View layout = getLayoutInflater(null).inflate(R.layout.discipline_detail_info, null);
        popup.setContentView(layout);
        TextView tv = (TextView) layout.findViewById(R.id.tvCaption);
        tv.setText("Yo");
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(800);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }
}
