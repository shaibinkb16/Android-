package com.example.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM USERS", null);
    }

    public Boolean insertdata(String name, Integer marks, String surname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("SURNAME", surname);
        contentValues.put("MARKS", marks);
        long result = db.insert("USERS", null, contentValues);
        db.close();
        return result != -1;
    }

    public int deletedata(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("USERS", "NAME=?", new String[]{name});
    }

    public Boolean updateData(String name, Integer marks, String surname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("SURNAME", surname);
        contentValues.put("MARKS", marks);
        int result = db.update("USERS", contentValues, "NAME=?", new String[]{name});
        return result > 0;
    }
}
