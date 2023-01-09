package com.example.practice_exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "itemDB";
    public static String TABLE_NAME = "item";
    public static String ID_COLUMN = "id";
    public static String CLIENT_NAME_COLUMN = "client_name";
    public static String NAME_COLUMN = "name";
    public static String AMOUNT_COLUMN = "amount";
    public static int DATABASE_VERSION = 1;

    DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY," +
                CLIENT_NAME_COLUMN + " TEXT," +
                NAME_COLUMN + " TEXT," +
                AMOUNT_COLUMN + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    // add Item
    public boolean addItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID_COLUMN, item.getId());
        cv.put(CLIENT_NAME_COLUMN, item.getClient_name());
        cv.put(NAME_COLUMN, item.getName());
        cv.put(AMOUNT_COLUMN, item.getAmount());

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    // update Item
    public boolean updateItem (int id, String client_name, String name, int amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID_COLUMN, id);
        cv.put(CLIENT_NAME_COLUMN, client_name);
        cv.put(NAME_COLUMN, name);
        cv.put(AMOUNT_COLUMN, amount);

        long result = db.update(TABLE_NAME, cv, ID_COLUMN + "=" + id, null);
        return result > 0;
    }

    // delete Item
    public boolean deleteItem (int id){
        boolean result = false;
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " = '" + String.valueOf(id) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        Item item = new Item();

        if (cursor.moveToFirst()) {
            item.setId(cursor.getInt(0));
            db.delete(TABLE_NAME, ID_COLUMN + "=?",
                    new String[]{
                            String.valueOf(item.getId())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    // list Item
    public List<Item> itemList (int id, String client_name, String name, int amount){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE (1 = 1)\n";

        if (id != -1){
            sql += " AND " + ID_COLUMN + " = " + id;
        }
        if (client_name != null){
            sql += " AND " + CLIENT_NAME_COLUMN + " LIKE '%" + client_name + "%'\n";
        }
        if (name != null){
            sql += " AND " + NAME_COLUMN + " LIKE '%" + name + "%'\n";
        }
        if (amount != -1){
            sql += " AND " + AMOUNT_COLUMN + " = " + amount;
        }

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            Item item = new Item(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3));
            list.add(item);
        }
        return list;
    }
}
