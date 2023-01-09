package com.example.practice_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edt_id, edt_client_name, edt_name, edt_amount;
    DBHelper db;
    MyAdapter myAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        edt_client_name = findViewById(R.id.edt_client_name);
        edt_name = findViewById(R.id.edt_name);
        edt_amount = findViewById(R.id.edt_amount);

        db = new DBHelper(this);
    }

    // Lay chuoi


    // Bat su kien onClick listItem
    public void listItem(View view){
        String r_id = edt_id.getText().toString().trim();
        String r_client_name = edt_client_name.getText().toString().trim();
        String r_name = edt_name.getText().toString().trim();
        String r_amount = edt_amount.getText().toString().trim();

        if (r_id == null || r_id.length() == 0){
            r_id = "-1";
        }
        if (r_amount == null || r_amount.length() == 0){
            r_amount = "-1";
        }
        List<Item> itemList = db.itemList(Integer.parseInt(r_id),
                r_client_name,
                r_name,
                Integer.parseInt(r_amount));
        recyclerView = findViewById(R.id.recyclerview);
        myAdapter = new MyAdapter(itemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    // Bat su kien onClick addItem
    public void addItem(View view){
        String r_id = edt_id.getText().toString().trim();
        String r_client_name = edt_client_name.getText().toString().trim();
        String r_name = edt_name.getText().toString().trim();
        String r_amount = edt_amount.getText().toString().trim();

        // Not fill all the fields
        if (r_id.isEmpty()
                || r_client_name.isEmpty()
                || r_name.isEmpty()
                || r_amount.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill all Field", Toast.LENGTH_LONG).show();
        }
        else {
            Item item = new Item(Integer.parseInt(r_id),
                    r_client_name,
                    r_name,
                    Integer.parseInt(r_amount));
            // check id exists or not
            // exist => update
            if (checkExistId(Integer.valueOf(r_id))){
                Boolean checkUpdate = db.updateItem(item.getId(), item.getClient_name(), item.getName(), item.getAmount());
                // set again edittext
                if (checkUpdate == true) {
                    edt_id.setText("");
                    edt_client_name.setText("");
                    edt_name.setText("");
                    edt_amount.setText("");
                    Toast.makeText(MainActivity.this, "This Record is Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "This Record is not Updated", Toast.LENGTH_LONG).show();
                }
            } // not exist => add new record
            else {
                Boolean checkInsert = db.addItem(item);
                if (checkInsert == true) {
                    edt_id.setText("");
                    edt_client_name.setText("");
                    edt_name.setText("");
                    edt_amount.setText("");
                    Toast.makeText(MainActivity.this, "New Record Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No Record Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // check id exists or not
    public boolean checkExistId(int id){
        List<Item> itemList = db.itemList(Integer.valueOf(edt_id.getText().toString()), "", "", -1);
        for (Item item : itemList){
            if (item.getId() == id){
                return true;
            }
        }
        return false;
    }

    // Bat su kien onClick update Item
    public void updateItem(View view){
        String r_id = edt_id.getText().toString().trim();
        String r_client_name = edt_client_name.getText().toString().trim();
        String r_name = edt_name.getText().toString().trim();
        String r_amount = edt_amount.getText().toString().trim();
        if (!r_id.isEmpty()
                && !r_client_name.isEmpty()
                && !r_name.isEmpty()
                && !r_amount.isEmpty()) {

            Boolean checkUpdate = db.updateItem(Integer.parseInt(r_id), r_client_name, r_name, Integer.parseInt(r_amount));
            if (checkUpdate == true) {
                edt_id.setText("");
                edt_client_name.setText("");
                edt_name.setText("");
                edt_amount.setText("");
                Toast.makeText(MainActivity.this, "This Record is Updated", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "This Record is not Updated", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Please fill all Field", Toast.LENGTH_LONG).show();
        }
    }

    // Bat su kien onClick delete Item
    public void deleteItem(View view){
        String r_id = edt_id.getText().toString().trim();

        if (!r_id.isEmpty()) {
            int idTXT = Integer.parseInt(r_id);
            Toast.makeText(MainActivity.this, "Please fill all Field", Toast.LENGTH_LONG).show();

            Boolean checkDelete = db.deleteItem(idTXT);
            if (checkDelete == true) {
                edt_id.setText("");
                Toast.makeText(MainActivity.this, "This Record is Deleted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "This Record is not Deleted", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Please fill all Field", Toast.LENGTH_LONG).show();
        }
    }
}
