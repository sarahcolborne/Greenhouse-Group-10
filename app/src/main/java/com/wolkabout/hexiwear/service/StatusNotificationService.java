package com.wolkabout.hexiwear.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.wolkabout.hexiwear.receiver.NotificationEventReceiver;

/**
 * Created by Hugh on 2017-06-08.
 */

public class StatusNotificationService extends IntentService {

    private static final int NOTIFICATION_ID = 1;
    private static final String ACTION_START = "ACTION_START";
    private static final String ACTION_DELETE = "ACTION_DELETE";

    public StatusNotificationService() {
        super(StatusNotificationService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(getClass().getSimpleName(), "onHandleIntent, started handling a notification event");
        try {
            String action = intent.getAction();
            if (ACTION_START.equals(action)) {
                processStartNotification();
            }
        } finally {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    private void processStartNotification() {
        //Check that temp, humidity, and light are within range
        public void checkGreenhouseStatus() {
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
}
}
