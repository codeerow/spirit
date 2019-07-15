package com.codeerow.spirit.aac_navigation.view

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.spirit.mvvm.view.MvvmActivity
import com.codeerow.spirit.navigation.view.BackPressedDelegate


/**
 * Activity that provides navigation with Android Architecture Navigation Component
 * */
abstract class AacNavigationActivity : MvvmActivity(),
        AacNavigationProvider {

    override val navHostFragment get() = supportFragmentManager.findFragmentById(settings.provideNavHostFragment.invoke()) as NavHostFragment


    /** lifecycle */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(settings.provideNavGraph.invoke())
        val args = Bundle()
        settings.configureStartArgs(args)
        navHostFragment.navController.setGraph(graph, args)
    }

    override fun onBackPressed() {
        val child = navHostFragment.childFragmentManager.fragments.firstOrNull()
        val handled = (child as? BackPressedDelegate)?.onBackPressed()
        if (handled == true) return
        super.onBackPressed()
    }
}