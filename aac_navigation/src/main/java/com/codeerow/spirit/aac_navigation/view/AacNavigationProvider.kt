package com.codeerow.spirit.aac_navigation.view

import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.codeerow.spirit.navigation.view.NavigationProvider


/**
 * Android Architecture Navigation provider interface.
 * */
interface AacNavigationProvider : NavigationProvider {
    var navController: MutableLiveData<NavController>
}
