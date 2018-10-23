package com.codeerow.pandora.box.navigation.view.widget

import android.support.design.widget.BottomNavigationView


interface BottomNavigationProvider {
    var buttonBar: BottomNavigationView


    fun handleUIConfiguration(configure: BottomNavigationView.() -> Unit) {
        configure.invoke(buttonBar)
    }
}