package com.codeerow.pandora.box.navigation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.pandora.box.mvvm.view.MvvmActivity
import com.codeerow.pandora.box.mvvm.viewmodel.MvvmViewModel


abstract class NavMvvmActivity<VS : Any, E : Any, VM : MvvmViewModel<VS, E>> : MvvmActivity<VS, E, VM>() {
    abstract val provideNavGraph: () -> Int
    abstract val provideStartDestination: () -> Int
    abstract val provideNavHostFragment: () -> Int
    open val configureStartArgs: Bundle.() -> Unit = {}

    lateinit var navHostFragment: NavHostFragment


    /* Lifecycle */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navHostFragment = findNavHostFragment()
        val graph = navHostFragment.inflateGraph()
        graph.configureNavGraph()
        navHostFragment.navController.graph = graph
    }


    /* Service Ext */
    private fun NavGraph.configureNavGraph() {
        val args = Bundle()
        configureStartArgs(args)
        setDefaultArguments(args)
        startDestination = provideStartDestination.invoke()
    }

    private fun AppCompatActivity.findNavHostFragment(): NavHostFragment {
        return supportFragmentManager.findFragmentById(provideNavHostFragment.invoke()) as NavHostFragment
    }

    private fun NavHostFragment.inflateGraph(): NavGraph {
        val inflater = this.navController.navInflater
        return inflater.inflate(provideNavGraph.invoke())
    }
}