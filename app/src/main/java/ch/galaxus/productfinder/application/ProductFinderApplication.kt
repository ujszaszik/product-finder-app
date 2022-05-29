package ch.galaxus.productfinder.application

import android.app.Application
import ch.galaxus.productfinder.BuildConfig
import ch.galaxus.productfinder.network.NetworkUtil
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class ProductFinderApplication : Application() {

    @Inject
    lateinit var networkUtil: NetworkUtil

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        networkUtil.registerNetworkCallback()
    }
}