package com.codeerow.presentation.ui.screens.fragment_d

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class DRouter : Router() {

    fun navigateA() {
        navigationBus.value = AacGoForward(actionID = R.id.action_DFragment_to_AFragment)
    }
}