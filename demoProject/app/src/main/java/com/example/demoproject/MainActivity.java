package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.demoproject.Adapters.MainAdapter;
import com.example.demoproject.Models.MainModel;
import com.example.demoproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Chicken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.burger2, "Burger New", "8", "New Burger"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "8", "Hawaii Pizza"));
        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Chicken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.burger2, "Burger New", "8", "New Burger"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "8", "Hawaii Pizza"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recycleview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleview.setLayoutManager(layoutManager);

    }
}