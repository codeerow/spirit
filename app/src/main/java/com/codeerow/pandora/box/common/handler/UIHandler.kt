package com.codeerow.pandora.box.common.handler

import com.codeerow.pandora.box.navigation.entity.UIConfiguration
import com.codeerow.pandora.box.navigation.view.widget.AppBarProvider
import com.codeerow.pandora.box.navigation.view.widget.BottomNavigationProvider
import com.codeerow.pandora.box.navigation.view.widget.CollapsingToolbarProvider
import com.codeerow.pandora.box.navigation.view.widget.ToolbarProvider


interface UIHandler {
//
//    fun handle(event: Event.UpdateUI) {
//        val uiConfiguration = event.uiConfiguration ?: viewModel.uiStack.peek().uiConfiguration
//        updateUI(uiConfiguration)
//    }


    fun updateUI(uiConfiguration: UIConfiguration) {
        if (this is BottomNavigationProvider) uiConfiguration.configureBottomNavigation.let(::handleUIConfiguration)
        if (this is CollapsingToolbarProvider) uiConfiguration.configureCollapsingToolbar.let(::handleUIConfiguration)
        if (this is AppBarProvider) uiConfiguration.configureAppBar.let(::handleUIConfiguration)
        if (this is ToolbarProvider) uiConfiguration.configureToolbar.let(::handleUIConfiguration)
    }
}