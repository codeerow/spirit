package com.codeerow.spirit.aac_navigation.view


import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.codeerow.spirit.navigation.view.BackPressedDelegate


/**
 * Fragment that provides navigation with Android Architecture Navigation Component
 * */
abstract class AacNavigationFragment : MvvmFragment(),
        BackPressedDelegate,
        AacNavigationProvider {


    /** lifecycle */
    override fun onBackPressed(): Boolean {
        val navHostFragment = childFragmentManager.fragments.firstOrNull()
        val childFragment = navHostFragment?.childFragmentManager?.fragments?.firstOrNull()
        var handled = (childFragment as? BackPressedDelegate)?.onBackPressed()
        if (handled == true) return true
        handled = navController.value?.navigateUp()
        if (handled == true && navHostFragment?.childFragmentManager?.backStackEntryCount == 0) return false
        return handled ?: false
    }
}