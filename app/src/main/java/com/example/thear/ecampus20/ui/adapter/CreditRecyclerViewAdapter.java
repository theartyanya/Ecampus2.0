package com.example.thear.ecampus20.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.CreditModel;

import java.util.List;
import java.util.Locale;

public class CreditRecyclerViewAdapter extends RecyclerView.Adapter<CreditRecyclerViewAdapter.ViewHolder> {
    private List<CreditModel> creditList;
    @Nullable private OnItemSelectedListener listener;

    public CreditRecyclerViewAdapter(List<CreditModel> creditList) {
        this.creditList = creditList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.credit_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.header.setText(creditList.get(position).getNameFull());
        holder.headerShort.setText(creditList.get(position).getNameShort());
        holder.cathedra.setText(creditList.get(position).getReadWhomName());
    }

    @Override
    public int getItemCount() {
        return creditList.size();
    }

    public void setListener(@Nullable OnItemSelectedListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView header, headerShort, cathedra;

        ViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.credit_list_name);
            headerShort = (TextView) itemView.findViewById(R.id.credit_list_name_short);
            cathedra = (TextView) itemView.findViewById(R.id.credit_list_cathedra);
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