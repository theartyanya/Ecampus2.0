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
import com.example.thear.ecampus20.model.RnpModel;
import com.example.thear.ecampus20.presentation.presenter.RnpPresenter;
import com.example.thear.ecampus20.presentation.view.RnpView;
import com.example.thear.ecampus20.ui.adapter.RnpRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RnpFragment extends MvpAppCompatFragment implements RnpView {
    @InjectPresenter
    RnpPresenter mRnpPresenter;

    RecyclerView recyclerView;
    List<RnpModel> npList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rnp, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        npList = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.rnp_recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        RnpRecyclerViewAdapter adapter = new RnpRecyclerViewAdapter(npList);
        recyclerView.setAdapter(adapter);
        mRnpPresenter.loadData(npList);
        adapter.setListener(new RnpRecyclerViewAdapter.OnItemSelectedListener() {
            @Override
            public void onSelected(int position) {
                if (!npList.isEmpty())
                    mRnpPresenter.moveToDetails(npList.get(position));
            }
        });
    }

    @Override
    public void updateView() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
