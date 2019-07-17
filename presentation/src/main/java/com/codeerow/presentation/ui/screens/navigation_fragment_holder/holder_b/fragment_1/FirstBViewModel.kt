package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_1

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate


class FirstBViewModel : MvvmViewModel() {

    /* Navigation */
    fun navigateSecondB() {
        navigate(AacGoForward(actionID = R.id.action_firstBFragment_to_secondBFragment))
    }
}