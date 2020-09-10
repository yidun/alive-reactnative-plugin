package com.livedetectdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by hzhuqi on 2020/8/21
 */
public class PreviewManager extends SimpleViewManager<FrameLayout> {
    private static final String NAME = "NTESRNLiveDetect";
    private FrameLayout cameraPreview;
    private AliveHelper aliveHelper;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected FrameLayout createViewInstance(ThemedReactContext reactContext) {
        Log.d(AliveHelper.TAG, "======createViewInstance======");
        Context context = reactContext.getApplicationContext();
        cameraPreview = (FrameLayout) LayoutInflater.from(reactContext.getCurrentActivity()).inflate(getLayoutId(context, "preview_layout"), null);
        reactContext.getCurrentActivity().findViewById(android.R.id.content).setBackgroundColor(Color.WHITE);
        aliveHelper = new AliveHelper(reactContext, cameraPreview.getId());
        aliveHelper.init(context, cameraPreview.findViewById(R.id.surface_view));
        aliveHelper.startDetected();
        return cameraPreview;
    }

    @Override
    public void onDropViewInstance(FrameLayout preview) {
        Log.d(AliveHelper.TAG, "======onDropViewInstance======");
        aliveHelper.stopDetected();
    }

    private int getLayoutId(Context context, String layoutName) {
        return context.getResources().getIdentifier(layoutName, "layout", context.getPackageName());
    }


//    @Override
//    public Map getExportedCustomDirectEventTypeConstants() {
//        return MapBuilder.of(
//                "onActionCommands", MapBuilder.of("registrationName", "onActionChange"),
//                "onError", MapBuilder.of("registrationName", "onWarnChange"),
//                "onStateTipChanged", MapBuilder.of("registrationName", "onStepChange"),
//                "onPassed", MapBuilder.of("registrationName", "onResultChange"));
//    }
//
//    @Override
//    public Map getExportedCustomBubblingEventTypeConstants() {
//        return MapBuilder.builder()
//                .put("onActionCommands", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onActionChange")))
//                .put("onError", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onWarnChange")))
//                .put("onStateTipChanged", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onStepChange")))
//                .put("onPassed", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onResultChange")))
//                .build();
//    }
}
