package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2

import androidx.lifecycle.MutableLiveData
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel


class SecondBViewModel : MvvmViewModel() {

    val exitWarningIsShown = MutableLiveData<Boolean>()
}