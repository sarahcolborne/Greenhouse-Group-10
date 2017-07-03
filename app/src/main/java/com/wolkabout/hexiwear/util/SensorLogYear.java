package com.wolkabout.hexiwear.util;

/**
 * Created by Ben on 2017-07-03.
 */

public class SensorLogYear {
    public SensorLogMonth[] months;
    public int size;
    public boolean changed;
    public Double avgTemp;
    public Double avgLux;
    public Double avgHumid;

    public SensorLogYear(){
        months = new SensorLogMonth[12];
        int size = 0;
        changed = false;
    }
    public SensorLogYear(boolean test, double temp, double lux, double humid){
        if(test){
            avgTemp=temp;
            avgLux=lux;
            avgHumid=humid;
            changed = false;
        }
        else{
            months = new SensorLogMonth[12];
            int size = 0;
            changed = false;
        }
    }

    public boolean addMonth(SensorLogMonth month){
        if(size==12){
            return false;
        }
        months[size]= month;
        size++;
        return true;
    }

    public double getAverageTemp(){
        if(!changed && avgTemp != null)
            return avgTemp;

        double total =0;
        for(int i=0; i<this.size; i++){
            total+=months[i].getAverageTemp();
        }
        avgTemp = total/size;
        return avgTemp;
    }

    public double getAverageLux(){
        if(!changed && avgLux != null)
            return avgLux;

        double total =0;
        for(int i=0; i<this.size; i++){
            total+=months[i].getAverageLux();
        }
        avgLux= total/size;
        return avgLux;
    }

    public double getAverageHumid(){
        if(!changed && avgHumid != null)
            return avgHumid;

        double total =0;
        for(int i=0; i<this.size; i++){
            total+=months[i].getAverageHumid();
        }
        avgHumid=total/size;
        return avgHumid;
    }
}
