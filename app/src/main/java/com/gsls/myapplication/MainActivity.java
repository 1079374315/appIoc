package com.gsls.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_round_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRoundIcon();
            }
        });

        findViewById(R.id.btn_primitive_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrimitiveIcon();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setRoundIcon();

            }
        }).start();

    }

    private void setRoundIcon() {
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".MainActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager
                .DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".RoundActivity"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager
                .DONT_KILL_APP);
    }

    private void setPrimitiveIcon() {
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                        ".RoundActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".MainActivity"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager
                .DONT_KILL_APP);
    }

}
