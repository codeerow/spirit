package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.view.AacNavSettings
import com.codeerow.spirit.aac_navigation.view.AacNavigationFragment
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel


class BHolderFragment : AacNavigationFragment() {
    override val viewModel: MvvmViewModel? = null

    override val settings = AacNavSettings(
            provideNavGraph = { R.navigation.b_holder_navigation_graph },
            provideNavHostFragment = { R.id.navFragment },
            provideStartDestination = { R.id.firstBFragment }
    )


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.holder_b_fragment, container, false)
    }
}