package com.codeerow.presentation.ui.screens.fragment_e

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class ERouter : Router() {


    /* Navigation */
    fun navigateD() {
        navigationBus.value = AacGoForward(actionID = R.id.action_EFragment_to_DFragment)
    }
}