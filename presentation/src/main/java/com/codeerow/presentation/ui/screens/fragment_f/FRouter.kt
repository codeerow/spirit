package com.codeerow.presentation.ui.screens.fragment_f

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class FRouter : Router() {

    fun navigateToHolderA() {
        navigationBus.value = AacGoForward(actionID = R.id.action_FFragment_to_holderAFragment)
    }
}