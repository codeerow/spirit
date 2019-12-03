package com.codeerow.presentation.ui.screens.fragment_b

import com.codeerow.presentation.R
import com.codeerow.presentation.ui.dialogs.choose_item.ChooseItemDialog
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.navigation.Router
import com.codeerow.spirit.navigation.command.ShowDialog


class BRouter : Router() {

    fun navigateC() {
        navigationBus.value = AacGoForward(actionID = R.id.action_BFragment_to_CFragment)
    }


    fun navigateF() {
        navigationBus.value = AacGoForward(actionID = R.id.action_BFragment_to_FFragment)
    }

    fun navigateItem() {
        navigationBus.value = ShowDialog(ChooseItemDialog())
    }
}