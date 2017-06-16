package com.example.thear.ecampus20.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.Discipline;
import com.example.thear.ecampus20.model.DisciplineModel;
import com.example.thear.ecampus20.presentation.presenter.DisciplinePresenter;
import com.example.thear.ecampus20.presentation.view.DisciplineView;
import com.example.thear.ecampus20.ui.adapter.DisciplineRecyclerViewAdapter;
import com.example.thear.ecampus20.ui.adapter.RnpRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DisciplineFragment extends MvpAppCompatFragment implements DisciplineView {
    @InjectPresenter
    DisciplinePresenter mPresenter;
    RecyclerView recyclerView;
    List<DisciplineModel> disciplineList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discipline, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        disciplineList = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.discipline_recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        DisciplineRecyclerViewAdapter adapter = new DisciplineRecyclerViewAdapter(disciplineList);
        recyclerView.setAdapter(adapter);
        mPresenter.loadData(disciplineList);
        adapter.setListener(new DisciplineRecyclerViewAdapter.OnItemSelectedListener() {
            @Override
            public void onSelected(int position) {
                if (!disciplineList.isEmpty())
                    mPresenter.moveToDetails(disciplineList.get(position));
            }
        });
    }

    @Override
    public void updateView() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
