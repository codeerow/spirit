package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate


class FirstAViewModel : MvvmViewModel() {

    /* Navigation */
    fun navigateSecondA() {
        navigate(AacGoForward(actionID = R.id.action_firstAFragment_to_secondAFragment))
    }
}