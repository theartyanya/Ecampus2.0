package com.example.thear.ecampus20.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.CreditModel;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.header.setText(creditList.get(position).getName());
        holder.headerShort.setText(creditList.get(position).getNameShort());
        holder.cathedra.setText(creditList.get(position).getReadWhomName());
        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onSelected(position, v, 0);
            }
        });
        holder.decreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onSelected(position, v, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return creditList.size();
    }

    public void setListener(@Nullable OnItemSelectedListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.credit_list_name)
        TextView header;
        @BindView(R.id.credit_list_name_short)
        TextView headerShort;
        @BindView(R.id.credit_list_cathedra)
        TextView cathedra;
        @BindView(R.id.credit_info_button)
        ImageButton infoButton;
        @BindView(R.id.credit_decree_button)
        ImageButton decreeButton;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemSelectedListener {
        void onSelected(int position, View button, int id);
    }
}