package com.codeerow.presentation.app

import android.app.Application
import com.codeerow.presentation.injection.app
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class SpiritApp : Application() {


    /* Lifecycle methods */
    override fun onCreate() {
        super.onCreate()
        instance = this
        Configurator().invoke(this)
        startKoin {
            androidLogger()
            androidContext(this@SpiritApp)
            modules(app)
        }
    }

    /* Companion */
    companion object {
        lateinit var instance: SpiritApp
    }
}