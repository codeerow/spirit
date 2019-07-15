package com.codeerow.presentation.injection.view

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule


@Module(includes = [
    AndroidSupportInjectionModule::class,
    FragmentBindingModule::class,
    ActivityBindingModule::class
])
abstract class ViewBindingModule