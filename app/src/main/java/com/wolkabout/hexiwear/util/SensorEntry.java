package com.wolkabout.hexiwear.util;

/**
 * Created by Ben on 2017-06-29.
 */

public class SensorEntry {

    public double temp;
    public double lux;
    public double humid;
    public long timeStamp;

    public SensorEntry(){
        timeStamp = System.currentTimeMillis();
    }

    public SensorEntry(double temp, double lux, double humid) {
        timeStamp = System.currentTimeMillis();
        this.temp=temp;
        this.lux=lux;
        this.humid=humid;
    }

    public Double getHumid() {
        return humid;
    }

    public Double getTemp() {
        return temp;
    }

    public Double getLux() {
        return lux;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setLux(double lux) {
        this.lux = lux;
    }

    public void setHumid(double humid) {
        this.humid = humid;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
