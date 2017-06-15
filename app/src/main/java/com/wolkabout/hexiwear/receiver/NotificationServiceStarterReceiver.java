package com.wolkabout.hexiwear.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wolkabout.hexiwear.receiver.NotificationEventReceiver;

/**
 * Created by Hugh on 2017-06-13.
 */

public class NotificationServiceStarterReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationEventReceiver.setupAlarm(context);
    }
}
