package com.example.demoserviceapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<UserModel> userModelList;
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyApiEndpointInterface myApiEndpointInterface = APIClient.getClient().create(MyApiEndpointInterface.class);

        Call<List<UserModel>> call = myApiEndpointInterface.getUser();

        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userModelList = response.body();
                Log.d("MainActivity", userModelList.toString());
                myAdapter = new MyAdapter(getApplicationContext(), userModelList);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.d("MainActivity", t.toString());
            }
        });
    }
}