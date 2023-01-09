package com.example.demomultithread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        handler  = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle b = msg.getData();
                tv.setText("count: " + b.getInt("count"));
            }
        };
    }

    int count = 0;
    public void onStart(View view) {
        long endtime = System.currentTimeMillis() + 10 * 1000;
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while(System.currentTimeMillis() < endtime){
                   synchronized (this){
                       try {
                           wait(1000);
                           count ++;
                           Bundle b = new Bundle();
                           b.putInt("count", count);
                           Message mess = handler.obtainMessage();
                           mess.setData(b);
                           handler.sendMessage(mess);
                       } catch (Exception e){
                       }
                   }
                }
            }
        });
        th.start();
    }
}