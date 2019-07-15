package com.codeerow.presentation.ui.screens.fragment_c

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate
import javax.inject.Inject


class CViewModel @Inject constructor() : MvvmViewModel() {


    /* Navigation */
    fun navigateD() {
        navigate(AacGoForward(
                actionID = R.id.action_CFragment_to_DFragment))
    }


    fun navigateE() {
        navigate(AacGoForward(
                actionID = R.id.action_CFragment_to_EFragment))
    }
}