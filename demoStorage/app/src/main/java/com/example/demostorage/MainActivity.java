package com.example.demostorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences spr;
    SharedPreferences.Editor editor;
    CheckBox cb;
    EditText edt_usn, edt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spr = getSharedPreferences("account", MODE_PRIVATE);
        editor = spr.edit();
        cb = findViewById(R.id.cb_remember);
        edt_usn = findViewById(R.id.edt_firstname);
        edt_pass = findViewById(R.id.edt_lastname);

        ((Button)findViewById(R.id.btn_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb.isChecked()){
                    editor = spr.edit();
                    editor.putString("username", edt_usn.getText().toString());
                    editor.putString("pass", edt_pass.getText().toString());
                }
                editor.putBoolean("issaved", cb.isChecked());
                editor.commit();
            }
        });

        ((Button)findViewById(R.id.btn_read)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = spr.getString("username", "");
                String pass = spr.getString("pass", "");
                boolean isChecked = spr.getBoolean("issaved", false);

                ((TextView)findViewById(R.id.tv_show)).setText(usr + "/" + pass + "/");
            }
        });

        ((Button)findViewById(R.id.btn_remove)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = spr.edit();
//                editor.remove("username");
                editor.clear();
                editor.commit();
            }
        });
    }
}