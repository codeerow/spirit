package com.codeerow.spirit.navigation.extensions

import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.command.NavigationCommand


/**
 * Navigates between views.
 * */
fun MvvmViewModel.navigate(navigation: NavigationCommand) {
    bus.accept(navigation)
}