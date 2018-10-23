package com.codeerow.pandora.box.navigation.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.pandora.box.common.handler.UIHandler
import com.codeerow.pandora.box.mvvm.view.MvvmFragment
import com.codeerow.pandora.box.navigation.entity.UIConfiguration
import com.codeerow.pandora.box.navigation.utils.uiConfiguration


abstract class NavFragment : MvvmFragment<Unit, Unit, NavViewModel>(),
        UIHandler {
    abstract val layoutRes: Int

    abstract val configureStartUI: UIConfiguration.() -> Unit
    abstract val provideNavHostFragment: () -> Int
    abstract val provideNavGraph: () -> Int
    abstract val provideStartDestination: () -> Int
    lateinit var navHostFragment: NavHostFragment


    override lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel by lazy { ViewModelProviders.of(this).get(NavViewModel::class.java) }


    /* Fragment was changed listener */
    private val updateUIDependsOnFragment = ViewTreeObserver.OnGlobalLayoutListener {
        val lastFragment = navHostFragment.childFragmentManager.fragments.lastOrNull()
                ?: return@OnGlobalLayoutListener
        val lastUIConfiguration = lastFragment.arguments.uiConfiguration
        lastUIConfiguration?.let(::updateUI) ?: performStartUIConfiguration(lastFragment)
    }


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navHostFragment = childFragmentManager.findFragmentById(provideNavHostFragment.invoke()) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(provideNavGraph.invoke())
        graph.startDestination = provideStartDestination.invoke()
        navHostFragment.navController.graph = graph
        view.viewTreeObserver.addOnGlobalLayoutListener(updateUIDependsOnFragment)
    }


    private fun performStartUIConfiguration(fragment: Fragment) {
        val startUI = UIConfiguration()
        configureStartUI(startUI)
        fragment.arguments.uiConfiguration = startUI
    }
}