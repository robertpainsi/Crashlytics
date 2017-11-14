package com.example.robert.example;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crashlytics.android.Crashlytics;

import java.security.AccessControlException;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);

        findViewById(R.id.button_crash_1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                throw new ArrayIndexOutOfBoundsException("Crash #1");
            }
        });

        findViewById(R.id.button_crash_2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                throw new AccessControlException("Crash #2");
            }
        });

        findViewById(R.id.button_crash_3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                throw new SQLiteException("Crash #3");
            }
        });
    }
}
