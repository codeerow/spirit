package com.codeerow.presentation.ui.screens.fragment_a

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router


class ARouter : Router() {

    fun navigateB() {
        navigationBus.value = AacGoForward(
                actionID = R.id.action_AFragment_to_BFragment)
    }

    fun navigateTransactions() {
        navigationBus.value = AacGoForward(
                actionID = R.id.action_AFragment_to_transactionsFragment)
    }
}
