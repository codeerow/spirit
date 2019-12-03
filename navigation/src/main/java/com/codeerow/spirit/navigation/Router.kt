package com.codeerow.spirit.navigation

import androidx.lifecycle.MutableLiveData
import com.codeerow.spirit.navigation.command.NavigationCommand


abstract class Router {
    val navigationBus = MutableLiveData<NavigationCommand>()
}