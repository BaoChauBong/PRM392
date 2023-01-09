package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.demoproject.Adapters.OrdersAdapter;
import com.example.demoproject.Models.OrdersModel;
import com.example.demoproject.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));
        list.add(new OrdersModel(R.drawable.burger, "Cheese Burger", "4", "1234321"));


        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}