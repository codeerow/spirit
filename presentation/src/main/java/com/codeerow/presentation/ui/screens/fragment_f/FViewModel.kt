package com.codeerow.presentation.ui.screens.fragment_f

import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.extensions.navigate
import javax.inject.Inject


class FViewModel @Inject constructor() : MvvmViewModel() {


    /* Navigation */
    fun navigateToHolderA() {
        navigate(AacGoForward(
                actionID = R.id.action_FFragment_to_holderAFragment))
    }
}