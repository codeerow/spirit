package com.codeerow.presentation.injection.view

import com.codeerow.presentation.injection.PerActivity
import com.codeerow.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}