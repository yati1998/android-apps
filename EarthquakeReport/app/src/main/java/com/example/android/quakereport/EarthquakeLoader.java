package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url ;
        // TODO: Finish implementing this constructor
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.v(LOG_TAG,"onStartLOading after forceLoad() executed!!");
    }

    @Override
    public List<Earthquake> loadInBackground() {
        // TODO: Implement this method
       // ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
        if(mUrl == null){
            return null ;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        Log.v(LOG_TAG,"loadInBackground() executed!!");
        return earthquakes;
    }
}
