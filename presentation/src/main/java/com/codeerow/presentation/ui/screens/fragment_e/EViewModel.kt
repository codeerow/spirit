package com.codeerow.presentation.ui.screens.fragment_e

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate


class EViewModel : MvvmViewModel() {


    /* Navigation */
    fun navigateD() {
        navigate(AacGoForward(
                actionID = R.id.action_EFragment_to_DFragment))
    }
}