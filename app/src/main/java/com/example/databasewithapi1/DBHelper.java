package com.example.databasewithapi1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MyWeather.db";
    public static final String TABLE_NAME = "test1";

    //TABLE COLUMNS

    public static final String CITY = "city";
    public static final String LOCT = "localtime";
    public static final String TEMP = "temperature";
    public static final String WIND = "wind";
    public static final String COND = "condition";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "( " +
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
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void insertData() {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CITY,API_Data.getStr_CITY());
        contentValues.put(LOCT,API_Data.getStr_LOCT());
        contentValues.put(TEMP,API_Data.getStr_TEMP());
        contentValues.put(WIND,API_Data.getStr_WIND());
        contentValues.put(COND,API_Data.getStr_COND());

        long result = db.insert(TABLE_NAME, null, contentValues);
    }

    public void queryData() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        while (res.moveToNext()) {
            Log.i("DBValues", " CITY is "+  res.getString(res.getColumnIndex(CITY))
                    + " \nLOCALTIME is " + res.getString(res.getColumnIndex(LOCT))
                    + " \nTEMP is " + res.getDouble(res.getColumnIndex(TEMP))
                    + " \nWIND is " + res.getDouble(res.getColumnIndex(WIND))
                    + " \nCOND is " + res.getString(res.getColumnIndex(COND))
            );
        }
    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM "+ TABLE_NAME , null);

        return result;
    }

    public void deleteData(){

    }

    public void updateData(){

    }
}
