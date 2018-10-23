package com.codeerow.pandora.box.navigation.view.widget

import android.support.v7.widget.Toolbar


interface ToolbarProvider {
    var toolbar: Toolbar

    fun handleUIConfiguration(configure: Toolbar.() -> Unit) {
        configure.invoke(toolbar)
    }
}