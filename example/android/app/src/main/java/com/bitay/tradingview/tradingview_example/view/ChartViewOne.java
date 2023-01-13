package com.bitay.tradingview.tradingview_example.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bitay.tradingview.tradingview_example.R;

import io.flutter.plugin.platform.PlatformView;

public class ChartViewOne implements PlatformView {

    @NonNull
    private LinearLayout view;

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    public ChartViewOne(@NonNull Context context) {
        view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.main_activity, null);
        //  view.addView(new CustomThemesViewKt(context));

        TextView textView = view.findViewById(R.id.text_view);
        textView.setText("Android Flutter Geliştirmeleri..");

    }

    @Override
    public void onFlutterViewAttached(@NonNull View flutterView) {
        PlatformView.super.onFlutterViewAttached(flutterView);
    }

    @Override
    public void dispose() {

    }
}
