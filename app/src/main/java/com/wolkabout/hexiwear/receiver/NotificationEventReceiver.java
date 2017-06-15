package com.wolkabout.hexiwear.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.wolkabout.hexiwear.service.StatusNotificationService;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hugh on 2017-06-13.
 */

public class NotificationEventReceiver extends WakefulBroadcastReceiver {

    private static final String ACTION_START_NOTIFICATION_SERVICE = "ACTION_START_NOTIFICATION_SERVICE";
    private static final String ACTION_DELETE_NOTIFICATION = "ACTION_DELETE_NOTIFICATION";
    private static final int NOTIFICATIONS_INTERVAL_IN_HOURS = 1;

    public static void setupAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent alarmIntent = getStartPendingIntent(context);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                getTriggerAt(new Date()),
                NOTIFICATIONS_INTERVAL_IN_HOURS * AlarmManager.INTERVAL_HOUR,
                alarmIntent);
    }

    public static void deleteAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent alarmIntent = getStartPendingIntent(context);
        alarmManager.cancel(alarmIntent);
    }

    public static boolean alarmRunning(Context context) {
        boolean isWorking = (PendingIntent.getService(context,
                0, new Intent("com.my.package.NotificationEventReceiver"),
                PendingIntent.FLAG_NO_CREATE) != null);
        if (isWorking){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Intent serviceIntent = null;
        if (ACTION_START_NOTIFICATION_SERVICE.equals(action)) {
            Log.i(getClass().getSimpleName(), "onReceive from alarm, starting notification service");
            serviceIntent = StatusNotificationService.createIntentStartNotificationService(context);
        } else if (ACTION_DELETE_NOTIFICATION.equals(action)) {
            Log.i(getClass().getSimpleName(), "onReceive delete notification action, starting notification service to handle delete");
            serviceIntent = StatusNotificationService.createIntentDeleteNotification(context);
        }

        if (serviceIntent != null) {
            startWakefulService(context, serviceIntent);
        }
    }

    private static long getTriggerAt(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        //calendar.add(Calendar.HOUR, NOTIFICATIONS_INTERVAL_IN_HOURS);
        return calendar.getTimeInMillis();
    }

    private static PendingIntent getStartPendingIntent(Context context) {
        Intent intent = new Intent(context, NotificationEventReceiver.class);
        intent.setAction(ACTION_START_NOTIFICATION_SERVICE);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static PendingIntent getDeleteIntent(Context context) {
        Intent intent = new Intent(context, NotificationEventReceiver.class);
        intent.setAction(ACTION_DELETE_NOTIFICATION);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}

