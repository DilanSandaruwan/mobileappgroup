package com.example.databasewithapi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btn_check = (Button)findViewById(R.id.button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkWeatherHere(View view)
    {
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        String city = btn_check.getText().toString();
        if(!city.equals("")){
            String url = "http://api.weatherapi.com/v1/forecast.json?key=49cff2e634f64d949d6165415200101&q="+city+"&days=2";
            Ion.with(this)
                    .load(url)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            Log.i("RESTAPI","cat dsta " + result);
                            displayInfo(result);
                        }
                    });
        }else{
            Toast.makeText(this, "Please enter the city to check weather.", Toast.LENGTH_SHORT).show();
        }


    }
    private void displayInfo(String result)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsonObject1 = jsonObject.getJSONObject("location");
            String title = jsonObject1.getString("name");
            TextView output = (TextView)findViewById(R.id.output);
            output.setText(title);

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

}
