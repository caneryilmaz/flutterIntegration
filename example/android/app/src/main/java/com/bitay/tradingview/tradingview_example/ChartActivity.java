package com.bitay.tradingview.tradingview_example;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.bitay.tradingview.tradingview_example.flutterFactory.ChartViewFactory;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

public class ChartActivity extends FlutterActivity {

    private static final String CHANNEL = "tradingview";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        flutterEngine
                .getPlatformViewsController()
                .getRegistry()
                .registerViewFactory("view1", new ChartViewFactory());

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    /**
     public NativeViewFactory getNativeView() {
     NativeViewFactory factory = new NativeViewFactory();
     return factory;
     } */
}
