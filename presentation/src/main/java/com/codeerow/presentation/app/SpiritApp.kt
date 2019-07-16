package com.codeerow.presentation.app

import android.app.Application


class SpiritApp : Application() {


    /* Lifecycle methods */
    override fun onCreate() {
        super.onCreate()
        instance = this
        Configurator().invoke(this)
    }

    /* Companion */
    companion object {
        lateinit var instance: SpiritApp
    }
}