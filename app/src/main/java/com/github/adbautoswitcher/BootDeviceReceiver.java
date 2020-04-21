package com.github.adbautoswitcher;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class BootDeviceReceiver extends BroadcastReceiver {
    private static final String TAG_BOOT_BROADCAST_RECEIVER = "BOOT_BROADCAST_RECEIVER";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(Intent.ACTION_BOOT_COMPLETED.equals(action)){
            Intent startServiceIntent = new Intent(context, RunAfterBootService.class);
            context.startForegroundService(startServiceIntent);
        }

    }

}
