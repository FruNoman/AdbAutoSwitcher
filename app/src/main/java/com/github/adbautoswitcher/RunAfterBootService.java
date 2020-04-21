package com.github.adbautoswitcher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RunAfterBootService extends Service {
    private static final String TAG_BOOT_EXECUTE_SERVICE = "BOOT_BROADCAST_SERVICE";

    public RunAfterBootService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Log.d(TAG_BOOT_EXECUTE_SERVICE, "RunAfterBootService onCreate() method.");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String message = "Turning on adb after boot complete";

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        Settings.Global.putInt(getApplicationContext().getContentResolver(), Settings.Global.ADB_ENABLED, 1);


        Log.d(TAG_BOOT_EXECUTE_SERVICE, "Adb turn on success: "+ getAdbState());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public boolean getAdbState() {
        try {
            int state = Settings.Global.getInt(getApplicationContext().getContentResolver(), Settings.Global.ADB_ENABLED);
            return state == 1 ? true : false;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }
}
