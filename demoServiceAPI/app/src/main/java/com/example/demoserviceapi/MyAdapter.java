package com.example.demoserviceapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context context;
    List<UserModel> userList;

    public MyAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_userId.setText(String.valueOf(userList.get(position).getUserId()));
        holder.tv_id.setText(String.valueOf(userList.get(position).getId()));
        holder.tv_title.setText(String.valueOf(userList.get(position).getTitle()));
        holder.tv_body.setText(String.valueOf(userList.get(position).getBody()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_userId, tv_id, tv_title, tv_body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_userId = itemView.findViewById(R.id.textUserId);
            tv_id = itemView.findViewById(R.id.textId);
            tv_title = itemView.findViewById(R.id.texttitle);
            tv_body = itemView.findViewById(R.id.textbody);
        }
    }
}
