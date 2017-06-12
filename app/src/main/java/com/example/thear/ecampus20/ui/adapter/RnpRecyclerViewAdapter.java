package com.example.thear.ecampus20.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.RnpModel;

import java.util.List;
import java.util.Locale;

public class RnpRecyclerViewAdapter extends RecyclerView.Adapter<RnpRecyclerViewAdapter.RnpViewHolder> {
    private List<RnpModel> items;
    @Nullable
    private OnItemSelectedListener listener;

    public RnpRecyclerViewAdapter(List<RnpModel> items) {
        this.items = items;
    }

    @Override
    public RnpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RnpViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.np_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RnpViewHolder holder, int position) {
        holder.id.setText(String.format(Locale.ENGLISH, "%d", items.get(position).getId()));
        holder.header.setText(items.get(position).getName());
        holder.okr.setText(items.get(position).getOkr());
        holder.form.setText(items.get(position).getStudyForm());
        if (items.get(position).getActuality()) {
            holder.actuality.setText("Актуально");
            holder.actuality.setTextColor(Color.rgb(0,204,0));
        } else {
            holder.actuality.setText("Не актуально");
            holder.actuality.setTextColor(Color.rgb(204,0,0));
        }
        holder.date.setText(items.get(position).getChangeDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class RnpViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id, header, okr, form, actuality, date;

        RnpViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.np_list_id);
            header = (TextView) itemView.findViewById(R.id.np_list_name);
            okr = (TextView) itemView.findViewById(R.id.np_list_okr);
            form = (TextView) itemView.findViewById(R.id.np_list_study_form);
            actuality = (TextView) itemView.findViewById(R.id.np_list_actuality);
            date = (TextView) itemView.findViewById(R.id.np_list_date);
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

    public void setListener(@Nullable RnpRecyclerViewAdapter.OnItemSelectedListener listener) {
        this.listener = listener;
    }
}
