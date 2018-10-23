package com.codeerow.pandora.box.navigation.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment


abstract class NavAppCompatActivity : AppCompatActivity() {
    abstract val layoutResID: Int

    abstract val provideNavGraph: () -> Int
    abstract val provideStartDestination: () -> Int
    abstract val provideNavHostFragment: () -> Int
    open val configureStartArgs: Bundle.() -> Unit = {}

    lateinit var navHostFragment: NavHostFragment


    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel by lazy { ViewModelProviders.of(this).get(NavViewModel::class.java) }


    /* Lifecycle */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID)
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