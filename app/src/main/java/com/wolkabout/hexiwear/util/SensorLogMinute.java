package com.wolkabout.hexiwear.util;

/**
 * Container for 1 minute worth of SensorEntry objects for uploading to firebase
 * has a <code>getAverage</code> method for temperature, light, and humidity
 * Created by Ben on 2017-07-03.
 */

public class SensorLogMinute {
    public SensorEntry[] secs;
    public int size;


    public SensorLogMinute(){
        secs = new SensorEntry[60];
        size = 0;
    }

    public void setSize(int i){
        size = i;
    }

    public boolean addSecond(SensorEntry entry){
        if(size==60){
            return false;
        }
        secs[size]=entry;
        size++;
        return true;
    }

    public double getAverageTemp(){
        double total =0;
        for(int i=0; i<this.size; i++){
            total+=secs[i].getTemp();
        }
        return total/size;
    }

    public double getAverageLux(){
        double total =0;
        for(int i=0; i<this.size; i++){
            total+=secs[i].getLux();
        }
        return total/size;
    }

    public double getAverageHumid(){
        double total =0;
        for(int i=0; i<this.size; i++){
            total+=secs[i].getHumid();
        }
        return total/size;
    }

}
