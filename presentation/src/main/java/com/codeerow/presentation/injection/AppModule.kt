package com.codeerow.presentation.injection

import android.app.Application
import android.content.Context
import com.codeerow.presentation.app.SpiritApp
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {

    @Binds
    abstract fun application(app: SpiritApp): Application

    @Binds
    abstract fun context(app: SpiritApp): Context
}