package com.example.demostorage;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    EditText edt_firstname;
    EditText edt_lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edt_firstname = findViewById(R.id.edt_firstname);
        edt_lastname = findViewById(R.id.edt_lastname);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user_db").allowMainThreadQueries().build();

        ((Button) findViewById(R.id.btn_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setFirstName(edt_firstname.getText().toString());
                user.setLastName(edt_lastname.getText().toString());
                UserDao userDao = db.userDao();
                userDao.insertAll(user);
            }
        });

        ((Button)findViewById(R.id.btn_read)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDao userDao = db.userDao();
                List<User> users = userDao.getAll();
                Log.d("users_size", "" + users.size());
                String all_users = "";
                for (User u : users){
                    String line = u.getUid() + ": " + u.getFirstName() + ", "
                            + u.getLastName() + "\n";
                    all_users += line;
                }
                ((TextView) findViewById(R.id.tv_show)).setText(all_users);
            }
        });
    }
}