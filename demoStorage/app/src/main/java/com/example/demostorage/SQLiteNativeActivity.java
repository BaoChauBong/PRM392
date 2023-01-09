package com.example.demostorage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteNativeActivity extends AppCompatActivity {
    SQLiteOpenHelper sqlHelper;
    SQLiteDatabase db;

    EditText edt_firstname;
    EditText edt_lastname;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main2);
        edt_firstname = findViewById(R.id.edt_firstname);
        edt_lastname = findViewById(R.id.edt_lastname);

        ((Button)findViewById(R.id.btn_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlHelper = new UserSQLiteOpenHelper(SQLiteNativeActivity.this, "users_db", null, 1);
                db = sqlHelper.getWritableDatabase();
                String sql = "INSERT INTO users (firstname, lastname) VALUES (?, ?)";
                db.execSQL(sql, new String[]{edt_firstname.getText().toString(), edt_lastname.getText().toString()});
                db.close();
            }
        });

        ((Button) findViewById(R.id.btn_read)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sql = "SELECT * FROM users";
                db = sqlHelper.getWritableDatabase();
                Cursor c = db.rawQuery(sql, null);
                String all_users = "";
                while(c.moveToNext()){
                    int uid = c.getInt(0);
                    String firstname = c.getString(1);
                    String lastname = c.getString(2);
                    String line = uid + ": " + firstname + ", " + lastname +"\n";
                    all_users += line;
                }
                ((TextView)findViewById(R.id.tv_show)).setText(all_users);
                db.close();
            }
        });
    }
}