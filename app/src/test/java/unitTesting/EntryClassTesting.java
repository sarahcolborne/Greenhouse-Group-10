package unitTesting;

import com.wolkabout.hexiwear.util.SensorEntry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ben on 2017-06-29.
 */

public class EntryClassTesting {


    SensorEntry test = new SensorEntry();

    @Test
    public void testTimeStamp(){
        assertNotNull(test.getTimeStamp());
    }
    @Test
    public void testSetGetTemp(){
        test.setTemp(10);
        assertTrue(10==test.getTemp());
    }
    @Test
    public void testSetGetHumid(){
        test.setHumid(10);
        assertTrue(10==test.getHumid());
    }
    @Test
    public void testSetGetLight(){
        test.setLux(10);
        assertTrue(10==test.getLux());
    }
}
