package com.example.databasewithapi1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherListAdapter extends ArrayAdapter<WeatherDetail> {
    private static final String TAB = "WeatherListAdapter";
    private Context mContext;
    int mResource;

    public WeatherListAdapter(Context context, int resource, ArrayList<WeatherDetail> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
       WeatherDetail wet = new WeatherDetail();
       wet.setCITY_str(getItem(position).getCITY_str());
       wet.setLOCT_str(getItem(position).getLOCT_str());
       wet.setTEMP_str(getItem(position).getTEMP_str());
       wet.setWIND_str(getItem(position).getWIND_str());
       wet.setCOND_str(getItem(position).getCOND_str());
//        String city = getItem(position).getCITY_str();
//        String loct = getItem(position).getLOCT_str();
//        Double temp = getItem(position).getTEMP_str();
//        Double wind = getItem(position).getWIND_str();
//        String cond = getItem(position).getCOND_str();
//
//        WeatherDetail wet= new WeatherDetail(city,loct,temp,wind,cond);


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvCity =(TextView)convertView.findViewById(R.id.txtv_1);
        TextView tvLoct =(TextView)convertView.findViewById(R.id.txtv_2);
        TextView tvTemp =(TextView)convertView.findViewById(R.id.txtv_3);
        TextView tvWind =(TextView)convertView.findViewById(R.id.txtv_4);

        tvCity.setText(wet.getCITY_str());
        tvLoct.setText(wet.getLOCT_str());
        tvTemp.setText(Double.toString(wet.getTEMP_str()));
        tvWind.setText(Double.toString(wet.getWIND_str()));

        return convertView;
    }

}
