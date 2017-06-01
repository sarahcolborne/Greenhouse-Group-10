package school.ben.greenhousebackup;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void basicTemperatureTests() throws Exception {
        Double testTemp = 5.0;

        Temperature temperature = new Temperature();
        temperature.setCurrTemp(testTemp);

        assertEquals(temperature.getCurrTemp(), testTemp);

        temperature.changeTempRange(1.5, 6.8);
        assertTrue(temperature.checkCurrTempInRange());

    }

    @Test
    public void basicHumidityTests() throws Exception {
        Double testHumidity = 5.0;

        Humidity humidity = new Humidity();
        humidity.setCurrHumidity(testHumidity);

        assertEquals(humidity.getCurrHumidity(), testHumidity);

        humidity.changeHumidityRange(1.5, 6.8);
        assertTrue(humidity.checkCurrHumidityInRange());

    }

    @Test
    public void basicLightLevelTests() throws Exception {
        Double testLight = 5.0;

        LightLevel lightLevel = new LightLevel();
        lightLevel.setCurrLight(testLight);

        assertEquals(lightLevel.getCurrLight(), testLight);

        lightLevel.changeLightRange(1.5, 6.8);
        assertTrue(lightLevel.checkCurrLightInRange());

    }

}