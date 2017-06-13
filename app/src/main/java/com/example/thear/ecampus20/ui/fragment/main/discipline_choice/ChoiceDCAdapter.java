package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.Block;
import com.example.thear.ecampus20.model.BlockDisc;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aleks on 13.06.2017.
 */

public class ChoiceDCAdapter extends RecyclerView.Adapter<ChoiceDCAdapter.ViewHolder> {

    private List<Block> blocks;
    private Context context;

    public ChoiceDCAdapter(List<Block> blocks, Context context) {
        this.blocks = blocks;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_do_dc_choice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(blocks.get(position));
    }

    @Override
    public int getItemCount() {
        return blocks.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.dcItemComponentTextView)
        TextView componentTextView;
        @BindView(R.id.dcItemBlockTextView)
        TextView blockTextView;
        @BindView(R.id.dcItemDcCountTextView)
        TextView countTextView;
        @BindView(R.id.dcItemRadioGroup)
        LinearLayout radioGroup;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final Block block) {
            componentTextView.setText(block.getComponent().getName());
            blockTextView.setText(block.getBlock().getName());
            countTextView.setText(String.valueOf(block.getDisciplineCount()));
            LayoutInflater inflater = LayoutInflater.from(context);
            radioGroup.removeAllViews();
            final List<RadioButton> radioButtons = new ArrayList<>();
            for (final BlockDisc b : block.getBlockDisc()) {
                final View view = inflater.inflate(R.layout.layout_do_dc_choice, null);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                radioGroup.addView(view);
                final RadioButton radioButton = ButterKnife.findById(view, R.id.radioButton);
                radioButtons.add(radioButton);
                if (b.isChecked()) {
                    radioButton.setChecked(true);
                }
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            for (RadioButton r : radioButtons) {
                                r.setChecked(false);
                            }
                            for (BlockDisc b : block.getBlockDisc()) {
                                b.setChecked(false);
                            }
                            buttonView.setChecked(true);
                            b.setChecked(true);
                        }
                    }
                });
                radioButton.setText(b.getNameUkr());
                ImageView imageView = ButterKnife.findById(view, R.id.imageView);
                imageView.setTag(b);
                imageView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {

        }
    }
}
