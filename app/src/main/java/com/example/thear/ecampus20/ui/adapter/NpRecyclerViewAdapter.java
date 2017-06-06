package com.example.thear.ecampus20.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.rnp.NpModel;
import com.example.thear.ecampus20.presentation.presenter.RnPresenter;

import java.util.List;

public class NpRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NpModel> npList;
    public NpRecyclerViewAdapter(List<NpModel> npList, RnPresenter presenter) {
        this.npList = npList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.np_list_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new NpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((NpViewHolder)holder).header.setText(npList.get(position).getName());
        ((NpViewHolder)holder).okr.setText(npList.get(position).getOkr().getName());
        ((NpViewHolder)holder).form.setText(npList.get(position).getStudyForm().getName());
        ((NpViewHolder)holder).actuality.setText(npList.get(position).getActuality().toString());
        ((NpViewHolder)holder).date.setText(npList.get(position).getChangeDate());
    }

    @Override
    public int getItemCount() {
        return npList.size();
    }

    private static class NpViewHolder extends RecyclerView.ViewHolder {
        TextView header, okr, form, actuality, date;
        NpViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.np_list_name);
            okr = (TextView) itemView.findViewById(R.id.np_list_okr);
            form = (TextView) itemView.findViewById(R.id.np_list_study_form);
            actuality = (TextView) itemView.findViewById(R.id.np_list_actuality);
            date = (TextView) itemView.findViewById(R.id.np_list_date);
        }
    }
}
