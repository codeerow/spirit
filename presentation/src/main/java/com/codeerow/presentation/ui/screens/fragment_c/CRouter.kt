package com.codeerow.presentation.ui.screens.fragment_c

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class CRouter : Router() {

    /* Navigation */
    fun navigateD() {
        navigationBus.value = AacGoForward(actionID = R.id.action_CFragment_to_DFragment)
    }


    fun navigateE() {
        navigationBus.value = AacGoForward(actionID = R.id.action_CFragment_to_EFragment)
    }
}