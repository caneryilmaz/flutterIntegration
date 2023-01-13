package com.bitay.tradingview.tradingview_example.flutterFactory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bitay.tradingview.tradingview_example.view.ChartViewOne;
import com.bitay.tradingview.tradingview_example.view.ChartViewTwo;

import java.util.Map;

import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class ChartViewFactory extends PlatformViewFactory {

    public ChartViewFactory() {
        super(StandardMessageCodec.INSTANCE);
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new ChartViewOne(context);
    }
}
