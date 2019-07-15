package com.codeerow.spirit.aac_navigation.view


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.codeerow.spirit.navigation.view.BackPressedDelegate


/**
 * Fragment that provides navigation with Android Architecture Navigation Component
 * */
abstract class AacNavigationFragment : MvvmFragment(),
        BackPressedDelegate,
        AacNavigationProvider {

    override val navHostFragment by lazy { childFragmentManager.findFragmentById(settings.provideNavHostFragment.invoke()) as NavHostFragment }


    /* lifecycle */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(settings.provideNavGraph.invoke())
        val args = Bundle()
        settings.configureStartArgs(args)
        navHostFragment.navController.setGraph(graph, args)
    }


    override fun onBackPressed(): Boolean {
        val childFragment = navHostFragment.childFragmentManager.fragments.firstOrNull()
        var handled = (childFragment as? BackPressedDelegate)?.onBackPressed()
        if (handled == true) return true
        handled = navHostFragment.navController.navigateUp()
        if (handled == true && navHostFragment.childFragmentManager.backStackEntryCount == 0) return false
        return handled
    }
}