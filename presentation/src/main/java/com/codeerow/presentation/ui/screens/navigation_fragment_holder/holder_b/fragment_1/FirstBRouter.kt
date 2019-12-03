package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_1

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class FirstBRouter : Router() {

    /* Navigation */
    fun navigateSecondB() {
        navigationBus.value = AacGoForward(actionID = R.id.action_firstBFragment_to_secondBFragment)
    }
}