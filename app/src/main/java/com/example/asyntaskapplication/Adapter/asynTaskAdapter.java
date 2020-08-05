package com.example.asyntaskapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.asyntaskapplication.Model.AsynList;
import com.example.asyntaskapplication.R;

import java.util.List;

public class asynTaskAdapter extends RecyclerView.Adapter<asynTaskAdapter.viewHolder> {
    @NonNull

    List<AsynList> list;
    Context mContext;

    public asynTaskAdapter(@NonNull List<AsynList> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public asynTaskAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_item, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull asynTaskAdapter.viewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(list.get(position).getThumbnail()).apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background)).into(holder.mimg_newway);

        holder.mstore_name.setText(list.get(position).getStr_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView mstore_name;
        ImageView mimg_newway;
        CardView mcard_newway;
        public viewHolder(@NonNull View itemView) {

            super(itemView);

            mimg_newway = itemView.findViewById(R.id.img_newway);
            mstore_name = itemView.findViewById(R.id.store_name);
            mcard_newway = itemView.findViewById(R.id.card_newway);
        }
    }
}
