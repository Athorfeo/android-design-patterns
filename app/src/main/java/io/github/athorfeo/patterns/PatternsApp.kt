package io.github.athorfeo.patterns

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.athorfeo.patterns.network.NetworkConnectionHelper
import javax.inject.Inject

@HiltAndroidApp
class PatternsApp: Application() {
    @Inject lateinit var networkConnectionHelper: NetworkConnectionHelper

    override fun onCreate() {
        super.onCreate()
        networkConnectionHelper.registerNetworkCallback(applicationContext)
    }
}
