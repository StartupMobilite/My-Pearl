package com.example.andji.mypearl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andji on 18/11/2015.
 */
public class CreateDataBase extends SQLiteOpenHelper
{

    public  static final String DATABASE_NAME = "test.db";
    public  static final String TABLE_NAME = "test_database";
    public  static final String COL_1 = "ID";
    public  static final String COL_2 = "NOM";
    public  static final String COL_3 = "PRENOM";
    public  static final String COL_4 = "PASSWORD";
    public  static final String COL_5 = "LOGIN";




    public CreateDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOM TEXT,PRENOM TEXT,PASSWORD TEXT,LOGIN TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String login,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5,login);
        contentValues.put(COL_4, password);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }





}
