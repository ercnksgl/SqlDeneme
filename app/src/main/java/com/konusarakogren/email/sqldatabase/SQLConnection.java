package com.konusarakogren.email.sqldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLConnection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sqldatabase.db";
    public static final int DATABASE_VERSION = 1;

    Context contex;

    public SQLConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.contex = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(" CREATE TABLE User( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, surname TEXT NOT NULL, age INTEGER, isMarried BOOLEAN DEFAULT 0 );");
            db.setTransactionSuccessful();
            Toast.makeText(contex, "Created Database", Toast.LENGTH_SHORT).show();
        }finally {
            db.endTransaction();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
