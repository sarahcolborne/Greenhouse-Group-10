package school.ben.greenhousebackup;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Need the following methods, should be added to the appropriate class:
    1) getHexiTemp, getHexiHumidity, getHexiLight
        these methods should return the actual values that the hexi sensor is currently reading

    2) getTempLowerBound, getHumidityLowerBound, getLightLowerBound
    3) getTempUpperBound, getHumidityUpperBound, getLightUpperBound
        these methods should return the currently STORED in our database

    4) getCurrentGraphContext
        returns "Current" or "Historic" depending on the current state of the graph
    5) set

    */
    //Check that temp, humidity, and light are within range
    boolean tempCheck, humidityCheck, lightCheck;
    public void checkGreenhouseStatus() {
        //check if notification has already been sent based on type
        tempCheck = false;
        humidityCheck = false;
        lightCheck = false;
        //Notify when below below temp range
        if (greenhouse.getHexiTemp() < greenhouse.getTempLowerBound()&& tempCheck = false)

        {
            NotificationCompat.Builder mBuilder0 = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Alert!")
                    .setContentText("Temperature is below range");
            NotificationManager NM0 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM0.notify(0, mBuilder0.build());
            tempCheck = true;
        }

        //Notify when above temp range
        if (greenhouse.getHexiTemp() > greenhouse.getTempUpperBound() && tempCheck = false)

        {
            NotificationCompat.Builder mBuilder1 = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Alert!")
                    .setContentText("Temperature is above range");
            NotificationManager NM1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM1.notify(1, mBuilder1.build());
            tempCheck = true;
        }
        //Notify when below humidity range
        if (greenhouse.getHexiHumidity() < greenhouse.getHumidityLowerBound() && humidityCheck = false)

        {
            NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Alert!")
                    .setContentText("Humidity is below range");
            NotificationManager NM2 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM2.notify(2, mBuilder2.build());
            humidityCheck = true;
        }
        //Notify when above humidity range
        if (greenhouse.getHexiHumidity() > greenhouse.getHumidityUpperBound() && humidityCheck = false)

        {
            NotificationCompat.Builder mBuilder3 = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Alert!")
                    .setContentText("Humidity is above range");
            NotificationManager NM3 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM3.notify(3, mBuilder3.build());
            humidityCheck = true;
        }
        //Notify when light is too low
        if (greenhouse.getHexiLight() < greenhouse.getLightLowerBound() && lightCheck = false)

        {
            NotificationCompat.Builder mBuilder4 = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Alert!")
                    .setContentText("Light is too low");
            NotificationManager NM4 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM4.notify(4, mBuilder4.build());
            lightCheck = true;
        }
        //Notify when light is too high
        if (greenhouse.getHexiLight() > greenhouse.getLightUpperBound() && lightCheck = false)

        {
            NotificationCompat.Builder mBuilder5 = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Alert!")
                    .setContentText("Light is too high");
            NotificationManager NM5 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM5.notify(5, mBuilder5.build());
            lightCheck = true;
        }
    }

}
