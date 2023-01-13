package com.bitay.tradingview.tradingview_example

import CustomThemesViewModel
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import io.flutter.embedding.android.FlutterFragmentActivity

interface MyViewModelAccessor {
    var viewModel: CustomThemesViewModel
    val activity: FlutterFragmentActivity
}

class MyViewModelInjector(val context: Context) : MyViewModelAccessor {
    override val activity: FlutterFragmentActivity by lazy {
        try {
            context as FlutterFragmentActivity
        } catch (exception: ClassCastException) {
            throw ClassCastException("Please ensure that the provided Context is a valid FragmentActivity")
        }
    }
    override var viewModel = ViewModelProvider(activity)[CustomThemesViewModel::class.java]
}