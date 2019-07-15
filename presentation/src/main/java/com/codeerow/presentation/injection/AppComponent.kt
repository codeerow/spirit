package com.codeerow.presentation.injection

import com.codeerow.presentation.app.SpiritApp
import com.codeerow.presentation.injection.view.ViewBindingModule
import com.codeerow.presentation.injection.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    ViewBindingModule::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<SpiritApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SpiritApp>()
}