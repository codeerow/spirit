package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate


class SecondAViewModel : MvvmViewModel() {

    /* Navigation */
    fun navigateToHolderB() {
        navigate(AacGoForward(
                actionID = R.id.action_holderAFragment_to_holderBFragment,
                forGraph = R.id.navigation_graph))
    }
}