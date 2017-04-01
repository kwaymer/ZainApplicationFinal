package com.example.zqamar.zainapplication;

import android.app.Application;

import com.example.zqamar.zainapplication.util.UtilLog;

/**
 * Created by zqamar on 2/23/17.
 */

public class ZainApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        UtilLog.setDebug(true);

    }
}
