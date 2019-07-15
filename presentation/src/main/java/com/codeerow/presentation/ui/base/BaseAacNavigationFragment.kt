package com.codeerow.presentation.ui.base

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import com.codeerow.spirit.aac_navigation.view.AacNavigationFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


abstract class BaseAacNavigationFragment : AacNavigationFragment(),
        HasSupportFragmentInjector {


    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory


    /* Dagger */
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    override fun supportFragmentInjector() = fragmentInjector

    override fun onAttach(context: Context) {
        // This is called even for API levels below 23.
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}