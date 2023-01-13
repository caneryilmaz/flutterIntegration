package com.bitay.tradingview.tradingview_example.view

import CustomThemesViewModel
import Data
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.Toast
import androidx.lifecycle.*
import com.bitay.tradingview.tradingview_example.MyViewModelAccessor
import com.bitay.tradingview.tradingview_example.MyViewModelInjector
import com.tradingview.lightweightcharts.api.chart.models.color.toIntColor
import com.tradingview.lightweightcharts.api.interfaces.ChartApi
import com.tradingview.lightweightcharts.api.interfaces.SeriesApi
import com.tradingview.lightweightcharts.api.options.models.*
import com.tradingview.lightweightcharts.api.series.enums.LineWidth
import com.tradingview.lightweightcharts.api.series.models.HistogramData
import com.tradingview.lightweightcharts.api.series.models.PriceScaleId
import com.tradingview.lightweightcharts.api.series.models.Time
import com.tradingview.lightweightcharts.api.series.models.WhitespaceData
import com.tradingview.lightweightcharts.runtime.plugins.DateTimeFormat
import com.tradingview.lightweightcharts.runtime.plugins.PriceFormatter
import com.tradingview.lightweightcharts.runtime.plugins.TimeFormatter
import com.tradingview.lightweightcharts.view.ChartsView
import io.flutter.embedding.android.FlutterFragmentActivity


class CustomThemesViewKt @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ChartsView(context, attrs, defStyleAttr, defStyleRes) {

    init {
        /**
        layoutParams = layoutParams.apply {
        width = LayoutParams.MATCH_PARENT
        height = LayoutParams.MATCH_PARENT
        } */



    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        lateinit var histogramSeries: SeriesApi
        api.addHistogramSeries(
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

        subscribeOnChartStateChange { state ->
            when (state) {
                is State.Preparing -> Unit
                is State.Ready -> {
                    Toast.makeText(context, "Chart is ready", Toast.LENGTH_SHORT).show()
                }
                is State.Error -> {
                    Toast.makeText(context, state.exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }


        api.applyOptions {
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
    }
}