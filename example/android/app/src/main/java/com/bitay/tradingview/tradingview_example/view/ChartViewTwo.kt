package com.bitay.tradingview.tradingview_example.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bitay.tradingview.tradingview_example.R
import com.tradingview.lightweightcharts.api.chart.models.color.toIntColor
import com.tradingview.lightweightcharts.api.interfaces.SeriesApi
import com.tradingview.lightweightcharts.api.options.models.layoutOptions
import com.tradingview.lightweightcharts.api.options.models.localizationOptions
import com.tradingview.lightweightcharts.api.series.models.HistogramData
import com.tradingview.lightweightcharts.api.series.models.Time
import com.tradingview.lightweightcharts.api.series.models.WhitespaceData
import com.tradingview.lightweightcharts.runtime.plugins.DateTimeFormat
import com.tradingview.lightweightcharts.runtime.plugins.PriceFormatter
import com.tradingview.lightweightcharts.runtime.plugins.TimeFormatter
import com.tradingview.lightweightcharts.view.ChartsView
import io.flutter.plugin.platform.PlatformView

class ChartViewTwo : PlatformView {

    private var view: ConstraintLayout
    private var charts_view: ChartsView
    lateinit var histogramSeries: SeriesApi

    constructor(context: Context) {
        view = LayoutInflater.from(context).inflate(R.layout.main_activity, null) as ConstraintLayout

        charts_view = view.findViewById<ChartsView>(R.id.charts_view)

        charts_view.api.applyOptions {
            layout = layoutOptions {
                backgroundColor = Color.LTGRAY.toIntColor()
                textColor = Color.BLACK.toIntColor()
            }
            localization = localizationOptions {
                locale = "ru-RU"
                priceFormatter = PriceFormatter(template = "{price:#2:#3}$")
                timeFormatter = TimeFormatter(
                    locale = "ru-RU",
                    dateTimeFormat = DateTimeFormat.DATE_TIME
                )
            }
        }

        charts_view.api.addHistogramSeries(
            onSeriesCreated = { series ->
                histogramSeries = series
            }
        )

        val data = listOf(
            HistogramData(Time.BusinessDay(2019, 6, 11), 40.01f),
            HistogramData(Time.BusinessDay(2019, 6, 12), 52.38f),
            HistogramData(Time.BusinessDay(2019, 6, 13), 36.30f),
            HistogramData(Time.BusinessDay(2019, 6, 14), 34.48f),
            WhitespaceData(Time.BusinessDay(2019, 6, 15)),
            WhitespaceData(Time.BusinessDay(2019, 6, 16)),
            HistogramData(Time.BusinessDay(2019, 6, 17), 41.50f),
            HistogramData(Time.BusinessDay(2019, 6, 18), 34.82f)
        )
        histogramSeries.setData(data)


        charts_view.subscribeOnChartStateChange { state ->
            when (state) {
                is ChartsView.State.Preparing -> Unit
                is ChartsView.State.Ready -> {
                    Toast.makeText(context, "Chart is ready", Toast.LENGTH_SHORT).show()
                }
                is ChartsView.State.Error -> {
                    Toast.makeText(context, state.exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getView(): View? {
        return view
    }


    override fun onFlutterViewAttached(flutterView: View) {
        super.onFlutterViewAttached(flutterView)
    }

    override fun dispose() {
    }
}