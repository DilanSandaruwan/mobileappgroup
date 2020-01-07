package com.example.databasewithapi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class View_DBData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__dbdata);
        //DBHelper dbh = getIntent().getParcelableExtra("dbhelper");
        Toast.makeText(this, "Activity success.Thank you!", Toast.LENGTH_SHORT).show();
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.queryData();
    }
}
