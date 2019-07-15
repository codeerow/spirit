package com.codeerow.presentation.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.codeerow.spirit.aac_navigation.view.AacNavigationActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


abstract class BaseAacNavigationActivity : AacNavigationActivity(),
        HasSupportFragmentInjector {

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    /* Dagger */
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    override fun supportFragmentInjector() = fragmentInjector
}