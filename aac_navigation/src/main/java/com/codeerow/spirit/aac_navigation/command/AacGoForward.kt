package com.codeerow.spirit.aac_navigation.command

import android.os.Bundle
import androidx.annotation.IdRes
import com.codeerow.spirit.navigation.command.GoForward
import com.codeerow.spirit.aac_navigation.view.AacNavigationProvider


/**
 * GoForward command implementation for Android Architecture Navigation Component.
 * */
class AacGoForward(@IdRes private val actionID: Int = -1,
                   private val configureArgs: Bundle.() -> Unit = {},
                   @IdRes private val forGraph: Int? = null) : GoForward<AacNavigationProvider>() {

    override fun handle(navigationProvider: AacNavigationProvider?): Boolean {
        if (navigationProvider == null) return false
        if (forGraph != null && navigationProvider.navHostFragment.navController.graph.id != forGraph) return false

        val bundle = Bundle()
        configureArgs(bundle)
        navigationProvider.navHostFragment.navController.navigate(actionID, bundle)
        return true
    }
}