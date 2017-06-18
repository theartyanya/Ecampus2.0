package com.example.thear.ecampus20.ui.adapter;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.DisciplineModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.header.setText(disciplineList.get(position).getNameFull());
        holder.cycle.setText(disciplineList.get(position).getComponent().getName());
        holder.code.setText(disciplineList.get(position).getShifr());

        if (disciplineList.get(position).getOutCredit() != null) {
            if (disciplineList.get(position).getOutCredit()) {
                holder.overcredit.setText("так");
                holder.overcredit.setTextColor(Color.rgb(0, 204, 0));
            } else {
                holder.overcredit.setText("ні");
                holder.overcredit.setTextColor(Color.rgb(204, 0, 0));
            }
        } else {
            holder.overcredit.setText("не вказано");
            holder.overcredit.setTextColor(Color.GRAY);
        }
        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onSelected(position, v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return disciplineList.size();
    }

    public void setListener(@Nullable OnItemSelectedListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.discipline_list_name)
        TextView header;
        @BindView(R.id.discipline_list_cycle)
        TextView cycle;
        @BindView(R.id.discipline_list_code)
        TextView code;
        @BindView(R.id.discipline_list_overcredit)
        TextView overcredit;
        @BindView(R.id.discipline_info_button)
        ImageView infoButton;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemSelectedListener {
        void onSelected(int position, View button);
    }
}