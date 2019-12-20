package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2

import androidx.lifecycle.MutableLiveData
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel
import com.codeerow.spirit.mvvm.viewmodel.decoration.SubscriptionDecoration


class SecondBViewModel(subscriptionDecoration: SubscriptionDecoration) : RxViewModel(subscriptionDecoration) {

    val exitWarningIsShown = MutableLiveData<Boolean>()
}