package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class FirstARouter : Router() {

    fun navigateSecondA() {
        navigationBus.value = AacGoForward(actionID = R.id.action_firstAFragment_to_secondAFragment)
    }
}