package com.codeerow.spirit.aac_navigation.view

import com.codeerow.spirit.mvvm.view.MvvmActivity
import com.codeerow.spirit.navigation.view.BackPressedDelegate


/**
 * Activity that provides navigation with Android Architecture Navigation Component
 * */
abstract class AacNavigationActivity : MvvmActivity(),
        AacNavigationProvider {


    /** lifecycle */
    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.fragments.firstOrNull()
        val child = navHostFragment?.childFragmentManager?.fragments?.firstOrNull()
        val handled = (child as? BackPressedDelegate)?.onBackPressed()
        if (handled == true) return
        super.onBackPressed()
    }
}