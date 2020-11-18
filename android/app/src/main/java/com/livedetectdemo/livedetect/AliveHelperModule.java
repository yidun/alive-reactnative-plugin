package com.livedetectdemo.livedetect;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.netease.nis.alivedetected.AliveDetector;

import androidx.annotation.NonNull;

/**
 * Created by hzhuqi on 2020/11/2
 */
public class AliveHelperModule extends ReactContextBaseJavaModule {
    private static final String ALIVE_HELPER = "AliveHelper";


    @ReactMethod
    public void startAlive() {
        AliveDetector.getInstance().startDetect();
    }

    @ReactMethod
    public void stopAlive() {
        AliveDetector.getInstance().stopDetect();
    }

    @NonNull
    @Override
    public String getName() {
        return ALIVE_HELPER;
    }
}
