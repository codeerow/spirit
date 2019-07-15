package com.codeerow.spirit.aac_navigation.view

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.spirit.navigation.view.NavigationProvider


/**
 * Android Architecture Navigation provider interface.
 * */
interface AacNavigationProvider : NavigationProvider {
    val navHostFragment: NavHostFragment

    val settings: AacNavSettings
}


/**
 * Properties for AacNavigationProvider.
 * */
data class AacNavSettings(val provideNavHostFragment: () -> Int,
                          val provideNavGraph: () -> Int,
                          val provideStartDestination: () -> Int,
                          val configureStartArgs: Bundle.() -> Unit = {})