package unitTesting;

import com.wolkabout.hexiwear.util.SensorEntry;
import com.wolkabout.hexiwear.util.SensorLogDay;
import com.wolkabout.hexiwear.util.SensorLogHour;
import com.wolkabout.hexiwear.util.SensorLogMinute;
import com.wolkabout.hexiwear.util.SensorLogMonth;
import com.wolkabout.hexiwear.util.SensorLogWeek;
import com.wolkabout.hexiwear.util.SensorLogYear;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Ben on 2017-07-03.
 */

public class SensorEntryContainerTests {
    SensorLogYear testYear;
    SensorLogMonth testMonth;
    SensorLogWeek testWeek;
    SensorLogDay testDay;
    SensorLogHour testHour;
    SensorLogMinute testMinute;
    double testMinAvg;
    double testHourAvg;
    double testDayAvg;
    double testWeekAvg;
    double testMonthAvg;
    double testYearAvg;

    @Before
    public void initialize(){
        //prepare for tests
        testMinute = new SensorLogMinute();
        for(int i=0; i<60; i++){
            testMinute.addEntry(new SensorEntry(i,i,i));
            testMinAvg+=i;
        }
        testMinAvg=testMinAvg/60;

        testHour = new SensorLogHour();
        for(int i=0; i<60; i++){
            testHour.addMinute(new SensorLogMinute(true,i,i,i));
        }
        testHourAvg = testMinAvg;

        testDayAvg = 0;
        testDay = new SensorLogDay();
        for(int i=0; i<24; i++){
            testDay.addHour(new SensorLogHour(true, i,i,i));
            testDayAvg+=i;
        }
        testDayAvg = testDayAvg/24;

        testWeekAvg=0;
        testWeek = new SensorLogWeek();
        for(int i=0; i<7; i++){
            testWeek.addDay(new SensorLogDay(true, i, i, i));
            testWeekAvg+=i;
        }
        testWeekAvg = testWeekAvg/7;

        testMonthAvg = 0;
        testMonth = new SensorLogMonth();
        for(int i=0; i<4; i++){
            testMonth.addWeek(new SensorLogWeek(true, i,i,i));
            testMonthAvg+=i;
        }
        testMonthAvg=testMonthAvg/4;

        testYearAvg=0;
        testYear = new SensorLogYear();
        for(int i=0; i<12; i++){
            testYear.addMonth(new SensorLogMonth(true, i, i, i));
            testYearAvg+=i;
        }
        testYearAvg=testYearAvg/12;

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
    public void testMinuteOverflow(){
        assertTrue(testMinute.size==60);
        assertFalse(testMinute.addEntry(new SensorEntry(1,1,1)));
    }
    @Test
    public void testMinOverflowInHour(){
        SensorLogHour overflowTest = new SensorLogHour();
        overflowTest.addMinute(testMinute);
        assertTrue(overflowTest.addEntry(new SensorEntry(10,10,10)));
        assertNotNull(overflowTest.mins[1]);
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
    public void dayGetAverageTempTest(){
        assertTrue(testDayAvg == testDay.getAverageTemp());
    }
    @Test
    public void dayGetAverageLuxTest(){
        assertTrue(testDayAvg == testDay.getAverageLux());
    }
    @Test
    public void dayGetAverageHumidTest(){
        assertTrue(testDayAvg == testDay.getAverageHumid());
    }

    @Test
    public void weekGetAverageTempTest(){
        assertTrue(testWeekAvg == testWeek.getAverageTemp());
    }
    @Test
    public void weekGetAverageLuxTest(){
        assertTrue(testWeekAvg == testWeek.getAverageLux());
    }
    @Test
    public void weekGetAverageHumidTest(){
        assertTrue(testWeekAvg == testWeek.getAverageHumid());
    }

    @Test
    public void monthGetAverageTempTest(){
        assertTrue(testMonthAvg == testMonth.getAverageTemp());
    }
    @Test
    public void monthGetAverageLuxTest(){
        assertTrue(testMonthAvg == testMonth.getAverageLux());
    }
    @Test
    public void monthGetAverageHumidTest(){
        assertTrue(testMonthAvg == testMonth.getAverageHumid());
    }
    @Test
    public void yearGetAverageTempTest(){
        assertTrue(testYearAvg == testYear.getAverageTemp());
    }
    @Test
    public void yearGetAverageLuxTest(){
        assertTrue(testYearAvg == testYear.getAverageLux());
    }
    @Test
    public void yearGetAverageHumidTest() {
        assertTrue(testYearAvg == testYear.getAverageHumid());
    }
}
