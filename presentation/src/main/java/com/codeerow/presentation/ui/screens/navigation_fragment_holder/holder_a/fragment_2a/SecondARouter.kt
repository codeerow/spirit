package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class SecondARouter : Router() {

    /* Navigation */
    fun navigateToHolderB() {
        navigationBus.value = AacGoForward(
                actionID = R.id.action_holderAFragment_to_holderBFragment,
                forGraph = R.id.navigation_graph)
    }
}