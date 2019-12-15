package com.codeerow.spirit.aac_navigation.command

import androidx.fragment.app.FragmentActivity
import com.codeerow.spirit.aac_navigation.view.AacNavigationProvider
import com.codeerow.spirit.navigation.command.GoBackward


/**
 * GoBackward command implementation for Android Architecture Navigation Component.
 * */
class AacGoBackward : GoBackward<AacNavigationProvider>() {

    override fun handleFragment(navigationProvider: AacNavigationProvider?): Boolean {
        if (navigationProvider == null) return false
        return navigationProvider.navController.value?.navigateUp() ?: false
    }

    override fun execute(activity: FragmentActivity) {
        val navigationProvider = activity as? AacNavigationProvider
        handled = navigationProvider?.navController?.value?.navigateUp() ?: false
        if (!handled) activity.finish()
    }
}