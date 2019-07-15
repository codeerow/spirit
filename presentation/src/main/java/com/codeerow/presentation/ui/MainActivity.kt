package com.codeerow.presentation.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.base.BaseAacNavigationActivity
import com.codeerow.spirit.aac_navigation.view.AacNavSettings
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseAacNavigationActivity() {

    override val viewModel: MvvmViewModel? = null


    override val settings = AacNavSettings(
            provideNavGraph = { R.navigation.navigation_graph },
            provideNavHostFragment = { R.id.navFragment },
            provideStartDestination = { R.id.AFragment }
    )

    /* Toolbar */
    private val toolbar: Toolbar by lazy { main_toolbar }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }


    /* Lifecycle */
    override fun inflateLayout() {
        setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
    }
}
