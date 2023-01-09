package com.example.demostorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserSQLiteOpenHelper extends SQLiteOpenHelper {

    public UserSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE users(uid INTEGER PRIMARY KEY, firstname TEXT, lastname TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            String sql = "DROP TABLE IF EXISTS users";
            sqLiteDatabase.execSQL(sql);
            sql = "CREATE TABLE users(uid INTEGER PRIMARY KEY, firstname TEXT, lastname TEXT)";
            sqLiteDatabase.execSQL(sql);
        }
    }
}
