package com.github.adbautoswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button turnOn;
    public Button turnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turnOn = findViewById(R.id.button);
        turnOff = findViewById(R.id.button2);

        turnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.Global.putInt(getContentResolver(), Settings.Global.ADB_ENABLED, 1);
            }
        });

        turnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.Global.putInt(getContentResolver(), Settings.Global.ADB_ENABLED, 0);
            }
        });
    }
}
