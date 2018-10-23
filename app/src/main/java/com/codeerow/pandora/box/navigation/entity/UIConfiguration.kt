package com.codeerow.pandora.box.navigation.entity

import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.Toolbar
import java.io.Serializable


data class UIConfiguration(var configureBottomNavigation: BottomNavigationView.() -> Unit = {},
                           var configureCollapsingToolbar: CollapsingToolbarLayout.() -> Unit = {},
                           var configureAppBar: AppBarLayout.() -> Unit = {},
                           var configureToolbar: Toolbar.() -> Unit = {}) : Serializable {
    fun clone(): UIConfiguration {
        return UIConfiguration(configureBottomNavigation, configureCollapsingToolbar, configureAppBar)
    }
}