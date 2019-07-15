package com.codeerow.presentation.app

import android.content.Context
import com.codeerow.presentation.app.configuration.loggingConfigurations


class Configurator {
    private val configurationTasks = listOf(loggingConfigurations)


    operator fun invoke(appContext: Context) {
        configurationTasks.map { configurations ->
            configurations.map { it.invoke(appContext) }
        }
    }
}