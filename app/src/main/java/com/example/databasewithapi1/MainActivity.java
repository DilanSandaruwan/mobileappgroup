package com.example.databasewithapi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Button btn_check = (Button)findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DBHelper DBH = new DBHelper(getApplicationContext());
    }

    public void checkDBConn(){

    }
    public void checkWeatherHere(View view)
    {
        EditText txt_city = (EditText)findViewById(R.id.txt_city);

        Log.i("checkWeather Entered","Looking here");
        String city = String.valueOf(txt_city.getText());
        String url = "http://api.weatherapi.com/v1/current.json?key=a4ba9fa04ed74e31a46150533200201&q="+city+"";
        //"http://samples.openweathermap.org/data/2.5/weather?q=London,uk"
        Log.i("checkWeather Entered","String here");
        Ion.with(this)
                .load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        Log.i("weather","details are available. "+ result);
                        displayInfo(result);
                    }
                });

        Log.i("checkWeather Entered","Finished here");
        //Toast.makeText(this, "Please enter the city to check weather.", Toast.LENGTH_SHORT).show();

        //}


    }
    private void displayInfo(String data)
    {
        Log.i("displayInfo.","Entered here");
        Toast.makeText(this, "Entered into displayInfo.", Toast.LENGTH_SHORT).show();
        try
        {
                Log.i("displayInfo.","try 1 here");
            JSONObject jsonObject = new JSONObject(data);
                Log.i("displayInfo.","try 2 here");
            JSONObject j_location = jsonObject.getJSONObject("location");
            JSONObject j_current = jsonObject.getJSONObject("current");
            JSONObject j_condition = j_current.getJSONObject("condition");

                Log.i("displayInfo.","Middle here");

            Toast.makeText(this, "hail me", Toast.LENGTH_SHORT).show();

            String str_name = j_location.getString("name");
            String str_temp_c = j_current.getString("temp_c");
            String str_wind = j_current.getString("wind_kph");
            String str_cond = j_condition.getString("text");
            String str_loctime = j_location.getString("localtime");
            String str_modified = j_current.getString("last_updated");

            TextView output_city = findViewById(R.id.txtv_output_city);
            TextView output_temp = findViewById(R.id.txtv_output_temp);
            TextView output_wind = findViewById(R.id.txtv_output_wind);
            TextView output_cond = findViewById(R.id.txtv_output_cond);
            TextView output_loctime = findViewById(R.id.txtv_output_localtime);
            TextView output_modified = findViewById(R.id.txtv_output_modified);

            output_city.setText(str_name);
            output_temp.setText(str_temp_c);
            output_wind.setText(str_wind);
            output_cond.setText(str_cond);
            output_loctime.setText(str_loctime);
            output_modified.setText(str_modified);

        }catch(JSONException e){
            Toast.makeText(this, "Exceptioned into displayInfo.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        Log.i("displayInfo.","Finished here");
        Toast.makeText(this, "Exited from displayInfo.", Toast.LENGTH_SHORT).show();
    }

}
