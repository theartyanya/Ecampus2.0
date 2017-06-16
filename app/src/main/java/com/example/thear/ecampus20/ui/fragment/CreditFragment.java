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
import com.example.thear.ecampus20.model.CreditModel;
import com.example.thear.ecampus20.presentation.presenter.CreditPresenter;
import com.example.thear.ecampus20.presentation.view.CreditView;
import com.example.thear.ecampus20.ui.adapter.CreditRecyclerViewAdapter;
import com.example.thear.ecampus20.ui.adapter.RnpRecyclerViewAdapter;

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
            public void onSelected(int position) {
                if (! creditList.isEmpty())
                    mPresenter.moveToDetails(creditList.get(position));
            }
        });
    }

    @Override
    public void updateView() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
