package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2

import androidx.lifecycle.MutableLiveData
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel


class SecondBViewModel : RxViewModel() {

    val exitWarningIsShown = MutableLiveData<Boolean>()
}