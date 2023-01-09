package com.example.demobroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;
    public static final String ACTION_CUSTOM_BROADCAST = "ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(ACTION_CUSTOM_BROADCAST);

        receiver = new MyReceiver();
        registerReceiver(receiver, intentFilter);
    }

    public void onSendBroadcast (View view){
        Intent intent = new Intent();
        intent.setAction(ACTION_CUSTOM_BROADCAST);
        intent.putExtra("data", "This is my custom broadcast");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}