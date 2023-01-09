package com.example.demohandlingaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
public class EventActivity extends AppCompatActivity implements View.OnClickListener{
*/
//      Cach 1: bat su kien
//    public void onClickButtonTest(View view) {
//        ((TextView) findViewById(R.id.tv_test)).setText("You clicked the button");
//        ((Button)view).setTextColor(Color.RED);
//    }
//    Button btn_click;

//      Cach 2: set lẻ
//    @Override
//   protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event);
//        btn_click = ((Button)findViewById(R.id.btn_click));
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((TextView) findViewById(R.id.tv_test)).setText("You clicked the button");
//                ((Button)view).setTextColor(Color.RED);
//            }
//        });
//    }

/*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                tv_test.setText("You've click to" + ((Button) view).getText());
                break;
            case R.id.btn_regis:
                tv_test.setText("You've click to" + ((Button) view).getText());
                break;
            case R.id.btn_forgot:
                tv_test.setText("You've click to" + ((Button) view).getText());
                break;
            default:
                break;
        }
    }*/

public class EventActivity extends AppCompatActivity{
    TextView tv_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        tv_test = findViewById(R.id.tv_test);

        ((LinearLayout)findViewById(R.id.li_test)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int count = motionEvent.getPointerCount();
                Log.d("Action Log", "action = " + motionEvent.getAction());
                Log.d("Action Log", "x = " + motionEvent.getX(0));
                return true;
            }
        });
    }





}