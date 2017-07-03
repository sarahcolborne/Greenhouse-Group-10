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
        int size;
    }
}
