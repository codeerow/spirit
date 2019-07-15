package com.codeerow.presentation.ui.screens.fragment_d

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate
import javax.inject.Inject


class DViewModel @Inject constructor() : MvvmViewModel() {


    /* Navigation */
    fun navigateA() {
        navigate(AacGoForward(
                actionID = R.id.action_DFragment_to_AFragment))
    }
}