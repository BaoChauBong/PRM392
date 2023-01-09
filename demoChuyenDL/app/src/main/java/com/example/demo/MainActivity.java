package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edt_fullname = findViewById(R.id.edt_fullname);
        EditText edt_age = findViewById(R.id.edt_age);

        // truyền dl bình thường
//        ((Button)findViewById(R.id.btn_next)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//
//                // put gộp
//                Bundle b = new Bundle();
//                b.putCharSequence("fullname", edt_fullname.getText());
//                b.putInt("age", Integer.valueOf(edt_age.getText().toString()));
//                intent.putExtra("data", b);
//
//                // put lẻ
////                intent.putExtra("fullname", edt_fullname.getText());
////                intent.putExtra("age",Integer.valueOf(edt_age.getText().toString()));
//
//                startActivity(intent);
//            }
//   });
//        // truyền object
//        ((Button) findViewById(R.id.btn_next)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//
//                PersonInfo person = new PersonInfo(edt_fullname.getText().toString(), Integer.valueOf(edt_age.getText().toString()));
//                intent.putExtra("person", person);
//                startActivity(intent);
//            }
//
//        });
//    }

        // Truyền URI
        ((Button) findViewById(R.id.btn_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uri = Uri.parse("https://www.google.com/");
//                Intent intent = new Intent(Intent.ACTION_VIEW);

                Uri uri = Uri.parse("tel:0334950656");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}