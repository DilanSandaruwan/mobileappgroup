package com.example.databasewithapi1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Person;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;

import java.util.ArrayList;

public class View_DBData extends AppCompatActivity {

    String item;
    Integer indexVal;
    ArrayAdapter myAdapter;
    ArrayList<WeatherDetail> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__dbdata);

        //DBHelper dbh = getIntent().getParcelableExtra("dbhelper");
        Toast.makeText(this, "Activity success.Thank you!", Toast.LENGTH_SHORT).show();
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.queryData();
        ////tbl = findViewById(R.id.tbl_data);
        Log.d("onCreate started","Made listView.");

        viewData();

        /********************/

    }

    public void viewData(){
        ListView listView = findViewById(R.id.my_listview);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        Cursor res = dbHelper.getAllData();

        arrayList = new ArrayList<>();

        while (res.moveToNext()) {
            //TableRow tableRow=new TableRow();
            WeatherDetail details=new WeatherDetail();
            details.setCITY_str(res.getString(res.getColumnIndex(DBHelper.CITY)));
            details.setLOCT_str(res.getString(res.getColumnIndex(DBHelper.LOCT)));
            details.setTEMP_str(res.getDouble(res.getColumnIndex(DBHelper.TEMP)));
            details.setWIND_str(res.getDouble(res.getColumnIndex(DBHelper.WIND)));
            details.setCOND_str(res.getString(res.getColumnIndex(DBHelper.COND)));
            //details.setStr_CITY(res.getString(res.getColumnIndex(DBHelper.CITY)));
//            Log.i("DBValues", " CITY is "+  res.getString(res.getColumnIndex(DBHelper.CITY))
//                    + " \nLOCALTIME is " + res.getString(res.getColumnIndex(DBHelper.LOCT))
//                    + " \nTEMP is " + res.getDouble(res.getColumnIndex(DBHelper.TEMP))
//                    + " \nWIND is " + res.getDouble(res.getColumnIndex(DBHelper.WIND))
//                    + " \nCOND is " + res.getString(res.getColumnIndex(DBHelper.COND))
//            );
            arrayList.add(details);
        }
        Log.i("Arraylist",arrayList.get(2).getCITY_str());
        WeatherListAdapter adapter = new WeatherListAdapter(this, R.layout.adapter_view_layout, arrayList);
        listView.setAdapter(adapter);
    }

    public void deleteData(){
        ListView listView = findViewById(R.id.my_listview);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString() + "has been selected.";
                Toast.makeText( View_DBData.this, "item ", Toast.LENGTH_SHORT).show();
                arrayList.remove(position);
                return true;
            }
        });
    }

}

