package com.example.databasewithapi1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MyWeather.db";
    public static final String TABLE_NAME = "test1";

    //TABLE COLUMNS
    public static final String ID = "id";
    public static final String CITY = "city";
    public static final String LOCT = "localtime";
    public static final String TEMP = "temp";
    public static final String WIND = "wind";
    public static final String COND = "condition";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "( " +
                    ""+ID+" INT PRIMARY KEY AUTOINCREMENT, " +
                    "" +CITY+" TEXT NOT NULL, " +
                    "" +LOCT+" TEXT NOT NULL, " +
                    "" +TEMP+" DECIMAL NOT NULL, " +
                    "" +WIND+" DECIMAL NOT NULL, " +
                    "" +COND+" TEXT NOT NULL"+
                    " );";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context){
        super(context,DB_NAME,null,1);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
