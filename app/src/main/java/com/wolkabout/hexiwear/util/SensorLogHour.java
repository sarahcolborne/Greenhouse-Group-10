package com.wolkabout.hexiwear.util;

/**
 * Stores an array of 60 SensorLogMinute objects
 * has methods to obtain average values for temp, light, humid
 * Created by Ben on 2017-07-03.
 */

public class SensorLogHour {
    public SensorLogMinute[] mins;
    public int size;

    public SensorLogHour(){
        mins = new SensorLogMinute[60];
        int size = 0;
    }

    public boolean addMinute(SensorLogMinute minute){
        if(size==60){
            return false;
        }
        mins[size]= minute;
        size++;
        return true;
    }

    public double getAverageTemp(){
        double total =0;
        for(int i=0; i<this.size; i++){
            total+=mins[i].getAverageTemp();
        }
        return total/size;
    }

    public double getAverageLux(){
        double total =0;
        for(int i=0; i<this.size; i++){
            total+=mins[i].getAverageLux();
        }
        return total/size;
    }

    public double getAverageHumid(){
        double total =0;
        for(int i=0; i<this.size; i++){
            total+=mins[i].getAverageHumid();
        }
        return total/size;
    }
}
