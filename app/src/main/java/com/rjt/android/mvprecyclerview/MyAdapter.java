package com.rjt.android.mvprecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rjt.android.mvprecyclerview.data.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<User> userData;
    private Context mContext;

    public MyAdapter(List<User> userData, Context context) {
        this.userData = userData;
        mContext = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.nameTv.setText(userData.get(position).getName());
        Picasso.with(mContext)
                .load(userData.get(position).getImgUrl())
                .into(holder.fileIv);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv;
        private ImageView fileIv;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            fileIv = itemView.findViewById(R.id.profileIv);
        }
    }
}
