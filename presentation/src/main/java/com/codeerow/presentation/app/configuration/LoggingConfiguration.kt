package com.codeerow.presentation.app.configuration

import android.content.Context
import timber.log.Timber


val loggingConfigurations = listOf(
        ::initTimber)


fun initTimber(appContext: Context) {
    Timber.plant(Timber.DebugTree())
}