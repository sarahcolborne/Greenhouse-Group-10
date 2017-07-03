package unitTesting;

import com.wolkabout.hexiwear.util.SensorEntry;
import com.wolkabout.hexiwear.util.SensorLogHour;
import com.wolkabout.hexiwear.util.SensorLogMinute;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Ben on 2017-07-03.
 */

public class SensorEntryContainerTests {
//    SensorLogYear testYear;
//    SensorLogMonth testMonth;
//    SensorLogDay testDay;
//    SensorLogHour testHour;
    SensorLogMinute testMinute;
    SensorLogHour testHour;
    double testMinAvg;
    double testHourAvg;
    @Before
    public void initialize(){
        //prepare for tests
        testMinute = new SensorLogMinute();
        for(int i=0; i<60; i++){
            testMinute.addSecond( new SensorEntry(i,i,i));
            testMinAvg+=i;
        }
        testMinAvg=testMinAvg/60;

        testHour = new SensorLogHour();
        for(int i=0; i<60; i++){
            testHour.addMinute(new SensorLogMinute(true,i,i,i));
        }
        testHourAvg = testMinAvg;

    }

    @Test
    public void minuteGetAverageTempTest(){
        assertTrue(testMinAvg == 29.5);
        assertTrue(testMinAvg == testMinute.getAverageTemp());
    }
    @Test
    public void minuteGetAverageLuxTest(){
       assertTrue(testMinAvg == testMinute.getAverageLux());
    }
    @Test
    public void minuteGetAverageHumidTest(){
       assertTrue(testMinAvg == testMinute.getAverageHumid());
    }

    @Test
    public void hourGetAverageTempTest(){
        assertTrue(testHourAvg == 29.5);
        assertTrue(testHourAvg == testHour.getAverageTemp());
    }
    @Test
    public void hourGetAverageLuxTest(){
        assertTrue(testHourAvg == testHour.getAverageLux());
    }
    @Test
    public void hourGetAverageHumidTest(){
        assertTrue(testHourAvg == testHour.getAverageHumid());
    }


    @Test
    public void addYearTest(){
        /*
        create a full year
        try to add a new entry
        verify that a new year object is created
         */

    }
    @Test
    public void yearGetAverageTempTest(){
        /*fill a year with constant value months
        check that the averageTemp method return matches the expected value
        calculated manually
         */
    }
    @Test
    public void yearGetAverageLightTest(){
        /*fill a year with constant value months
        check that the averageTemp method return matches the expected value
        calculated manually
         */
    }
    @Test
    public void yearGetAverageHumidityTest(){
        /*fill a year with constant value months
        check that the averageTemp method return matches the expected value
        calculated manually
         */
    }
}
