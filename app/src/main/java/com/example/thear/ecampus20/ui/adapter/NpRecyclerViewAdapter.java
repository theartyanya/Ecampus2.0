package com.example.thear.ecampus20.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.rnp.NpModel;
import com.example.thear.ecampus20.service.Path;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NpRecyclerViewAdapter extends RecyclerView.Adapter<NpRecyclerViewAdapter.NpViewHolder> {
    private List<NpModel> npList;
    @Nullable private OnItemSelectedListener listener;

    public NpRecyclerViewAdapter(List<NpModel> npList) {
        this.npList = npList;
    }

    @Override
    public NpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NpViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.np_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NpViewHolder holder, int position) {
        holder.header.setText(npList.get(position).getName());
        holder.okr.setText(npList.get(position).getOkr().getName());
        holder.form.setText(npList.get(position).getStudyForm().getName());
        if (npList.get(position).getActuality()) {
            holder.actuality.setText("Актуально");
            holder.actuality.setTextColor(Color.rgb(0,204,0));
        } else {
            holder.actuality.setText("Не актуально");
            holder.actuality.setTextColor(Color.rgb(204,0,0));
        }
        holder.date.setText(npList.get(position).getChangeDate());
    }

    @Override
    public int getItemCount() {
        return npList.size();
    }

    public void setListener(@Nullable OnItemSelectedListener listener) {
        this.listener = listener;
    }

    class NpViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.np_list_name)
        TextView header;
        @BindView(R.id.np_list_okr)
        TextView okr;
        @BindView(R.id.np_list_study_form)
        TextView form;
        @BindView(R.id.np_list_actuality)
        TextView actuality;
        @BindView(R.id.np_list_date)
        TextView date;

        NpViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onSelected(this.getAdapterPosition());
        }
    }

    public interface OnItemSelectedListener {
        void onSelected(int position);
    }
}