package com.example.thear.ecampus20.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.DisciplineModel;

import java.util.List;

public class DisciplineRecyclerViewAdapter extends RecyclerView.Adapter<DisciplineRecyclerViewAdapter.ViewHolder> {
    private List<DisciplineModel> disciplineList;
    @Nullable private OnItemSelectedListener listener;

    public DisciplineRecyclerViewAdapter(List<DisciplineModel> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.discipline_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.header.setText(disciplineList.get(position).getNameFull());
        holder.cycle.setText(disciplineList.get(position).getComponent().getName());
        holder.code.setText(disciplineList.get(position).getShifr());
        if (disciplineList.get(position).getOutCredit() != null) {
            if (disciplineList.get(position).getOutCredit()) {
                holder.overcredit.setText("Позакредитність: так");
                holder.overcredit.setTextColor(Color.rgb(0, 204, 0));
            } else {
                holder.overcredit.setText("Позакредитність: ні");
                holder.overcredit.setTextColor(Color.rgb(204, 0, 0));
            }
        }
    }

    @Override
    public int getItemCount() {
        return disciplineList.size();
    }

    public void setListener(@Nullable OnItemSelectedListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView header, cycle, code, overcredit;

        ViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.discipline_list_name);
            cycle = (TextView) itemView.findViewById(R.id.discipline_list_cycle);
            code = (TextView) itemView.findViewById(R.id.discipline_list_code);
            overcredit = (TextView) itemView.findViewById(R.id.discipline_list_overcredit);
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