package com.example.democontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Doc
    ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();
        requestPhonePermission(Manifest.permission.READ_PHONE_NUMBERS, 1000);
        requestPhonePermission(Manifest.permission.READ_CONTACTS, 1001);
    }

    public void onReadContact(View view) {
        Cursor c = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                new String[] {ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME},
                null, null, null);

        String contacts = "";

        while (c.moveToNext()){
            String line = "";
            int id_index = c.getColumnIndex(ContactsContract.Contacts._ID);
            long ID = c.getLong(id_index);
            int id_name = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name = c.getString(id_name);

            line += ID + ", " + name + ": ";

            String phones = "";
            Cursor c1 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[] {ContactsContract.CommonDataKinds.Phone.NUMBER},
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                    new String[] {String.valueOf(ID)}, null);
            while (c1.moveToNext()){
                int idx = c1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String phone = c1.getString(idx);
                phones += phone;
            }
            line += phones;
            contacts = contacts + line +"\n";
            ((TextView) findViewById(R.id.textView)).setText(contacts);
        }
    }

    public void requestPhonePermission(String permission, int code){
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[] {permission}, code);
        }
    }
}