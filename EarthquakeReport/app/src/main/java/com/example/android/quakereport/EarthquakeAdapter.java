package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.Earthquake;
import com.example.android.quakereport.R;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context , List<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView , ViewGroup parent){

        View listItemView = convertView ;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list_item,parent,false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView locView = (TextView) listItemView.findViewById(R.id.city);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        magView.setText(currentEarthquake.getMagnitude());
        locView.setText(currentEarthquake.getLocation());
        dateView.setText(currentEarthquake.getDate());

        return listItemView;
    }


}
