package com.codeerow.presentation.app

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.codeerow.presentation.injection.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class SpiritApp : Application(),
        HasSupportFragmentInjector,
        HasActivityInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    /* Lifecycle methods */
    override fun onCreate() {
        super.onCreate()
        instance = this
        setUpDagger()
        Configurator().invoke(this)
    }


    /* Dagger */
    override fun supportFragmentInjector() = fragmentInjector

    override fun activityInjector() = activityInjector

    private fun setUpDagger() {
        DaggerAppComponent.builder().create(this).inject(this)
    }


    /* Companion*/
    companion object {
        lateinit var instance: SpiritApp
    }
}