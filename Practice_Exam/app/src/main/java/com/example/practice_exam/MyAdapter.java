package com.example.practice_exam;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Item> itemList;

    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id.setText(String.valueOf(itemList.get(position).getId()));
        holder.tv_client_name.setText(String.valueOf(itemList.get(position).getClient_name()));
        holder.tv_name.setText(String.valueOf(itemList.get(position).getName()));
        holder.tv_amount.setText(String.valueOf(itemList.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_id, tv_client_name, tv_name, tv_amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.textid);
            tv_client_name = itemView.findViewById(R.id.textclientname);
            tv_name = itemView.findViewById(R.id.textname);
            tv_amount = itemView.findViewById(R.id.textamount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    itemList.get(position);
                }
            });
        }
    }
}
