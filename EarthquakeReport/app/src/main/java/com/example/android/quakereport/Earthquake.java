package com.example.android.quakereport;

public class Earthquake{

    public String mMagnitude ;

    public String mLocation;

    public String mDate;

    public Earthquake(String magnitude,String location , String date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date ;
    }

    public String getMagnitude(){
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }
}
