package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // truyền dl bình thường
//        // put gộp
//        Bundle b = getIntent().getBundleExtra("data");
//        CharSequence fullname = b.getCharSequence("fullname");
//        int age = b.getInt("age", 0);
//
//        // put lẻ
////        CharSequence fullname = getIntent().getCharSequenceExtra("fullname");
////        int age = getIntent().getIntExtra("age", 0);
//
//        ((TextView)findViewById(R.id.textView)).setText(fullname);
//        ((TextView)findViewById(R.id.textView2)).setText(age + " tuổi");

        // truyền object
        PersonInfo p = (PersonInfo) getIntent().getSerializableExtra("person");
        ((TextView)findViewById(R.id.textView)).setText(p.getFullname() + "/" + p.getAge());
    }
}