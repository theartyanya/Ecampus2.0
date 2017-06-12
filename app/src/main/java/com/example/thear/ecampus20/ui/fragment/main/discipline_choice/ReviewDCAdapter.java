package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.Block;
import com.example.thear.ecampus20.model.BlockDisc;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aleks on 12.06.2017.
 */

public class ReviewDCAdapter extends RecyclerView.Adapter<ReviewDCAdapter.ViewHolder> {

    private List<Block> blocks;
    private Context context;

    public ReviewDCAdapter(List<Block> blocks, Context context) {
        this.blocks = blocks;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View dcView = inflater.inflate(R.layout.item_view_dc_choice, parent, false);
        return new ViewHolder(dcView);
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
        @BindView(R.id.dcItemLinLayout)
        LinearLayout dcLinLayout;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Block block) {
            componentTextView.setText(block.getComponent().getName());
            blockTextView.setText(block.getBlock().getName());
            countTextView.setText(String.valueOf(block.getDisciplineCount()));
            LayoutInflater inflater = LayoutInflater.from(context);
            dcLinLayout.removeAllViews();
            for (BlockDisc b : block.getBlockDisc()) {
                View view = inflater.inflate(R.layout.layout_view_dc, dcLinLayout);
                TextView textView = ButterKnife.findById(view, R.id.textView);
                textView.setText(b.getNameUkr());
                ImageView imageView = ButterKnife.findById(view, R.id.imageView);
                imageView.setTag(b);
                imageView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            ImageView imageView = (ImageView) v;
            BlockDisc b = (BlockDisc) imageView.getTag();

        }
    }
}
