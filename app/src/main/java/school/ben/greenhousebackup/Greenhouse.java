package school.ben.greenhousebackup;

/**
 * Created by Sarah on 2017-06-01.
 */

public class Greenhouse {
    Temperature temperature;
    Humidity humidity;
    LightLevel lightLevel;

    public void checkTempInRange(){
        if (!temperature.checkCurrTempInRange()) {
            //handle bad temp
        }

    }

    public void checkHumidityInRange(){
        if (!humidity.checkCurrHumidityInRange()) {
            //handle bad humidity
        }

    }

    public void checkLightInRange(){
        if (!lightLevel.checkCurrLightInRange()) {
            //handle bad light level
        }

    }

}
