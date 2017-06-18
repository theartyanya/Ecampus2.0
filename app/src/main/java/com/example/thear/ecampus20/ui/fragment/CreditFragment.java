package com.example.thear.ecampus20.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.CreditModel;
import com.example.thear.ecampus20.presentation.presenter.CreditPresenter;
import com.example.thear.ecampus20.presentation.view.CreditView;
import com.example.thear.ecampus20.ui.adapter.CreditRecyclerViewAdapter;
import com.example.thear.ecampus20.ui.adapter.DisciplineRecyclerViewAdapter;
import com.example.thear.ecampus20.ui.adapter.RnpRecyclerViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CreditFragment extends MvpAppCompatFragment implements CreditView {
    @InjectPresenter
    CreditPresenter mPresenter;
    RecyclerView recyclerView;
    List<CreditModel> creditList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_credit, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         creditList = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.credit_recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        CreditRecyclerViewAdapter adapter = new CreditRecyclerViewAdapter(creditList);
        recyclerView.setAdapter(adapter);
        mPresenter.loadData( creditList);
        adapter.setListener(new CreditRecyclerViewAdapter.OnItemSelectedListener() {
            @Override
            public void onSelected(int position, View button, int id) {
                if (id == 0) {
                    if (!creditList.isEmpty()) {
                        PopupWindow popup = new PopupWindow(getContext());
                        View layout = getLayoutInflater(null).inflate(R.layout.credit_info, null);
                        popup.setContentView(layout);

                        TextView creditName = (TextView) layout.findViewById(R.id.credit_info_name);
                        creditName.setText(creditList.get(position).getName());

                        TextView knowledge = (TextView) layout.findViewById(R.id.credit_info_knowledge_name);
                        if (!creditList.get(position).getKnowledge().isEmpty())
                            knowledge.setText(creditList.get(0).getKnowledge());
                        else
                            knowledge.setText("не вказано");

                        TextView skill = (TextView) layout.findViewById(R.id.credit_info_skill_name);
                        if (!creditList.get(position).getSkill().isEmpty())
                            skill.setText(creditList.get(0).getSkill());
                        else
                            skill.setText("не вказано");

                        TextView competence = (TextView) layout.findViewById(R.id.credit_info_competence_name);
                        if (!creditList.get(position).getCompetence().isEmpty())
                            competence.setText(creditList.get(0).getCompetence());
                        else
                            competence.setText("не вказано");

                        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                        // Closes the popup window when touch outside of it - when looses focus
                        popup.setOutsideTouchable(true);
                        popup.setFocusable(true);
                        // Show anchored to button
                        popup.showAsDropDown(button);
                    }
                } else {
                    if (!creditList.isEmpty()) {
                        PopupWindow popup = new PopupWindow(getContext());
                        View layout = getLayoutInflater(null).inflate(R.layout.credit_decree_info, null);
                        popup.setContentView(layout);
                        if (!creditList.get(position).getDisciplineWhoRead().isEmpty()) {
                            TextView cathedraName = (TextView) layout.findViewById(R.id.credit_decree_cathedra_name);
                            cathedraName.setText(creditList.get(position).getDisciplineWhoRead().get(0).getWhoRead());
                            TextView year = (TextView) layout.findViewById(R.id.credit_decree_year_name);
                            year.setText(creditList.get(position).getDisciplineWhoRead().get(0).getName());
                        }
                        // Set content width and height
                        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                        // Closes the popup window when touch outside of it - when looses focus
                        popup.setOutsideTouchable(true);
                        popup.setFocusable(true);
                        // Show anchored to button
                        popup.showAsDropDown(button);
                    }
                }
            }
        });
    }

    @Override
    public void updateView() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
