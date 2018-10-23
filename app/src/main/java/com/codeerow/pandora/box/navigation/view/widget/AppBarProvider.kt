package com.codeerow.pandora.box.navigation.view.widget

import android.support.design.widget.AppBarLayout


interface AppBarProvider {
    var appBarLayout: AppBarLayout

    fun handleUIConfiguration(configure: AppBarLayout.() -> Unit) {
        configure.invoke(appBarLayout)
//        property.expanded?.let(::setExpanded)
//        property.title?.let(::setTitle)
//        if (this is Fragment) {
//            setHasOptionsMenu(true)
////            (activity as AppCompatActivity).apply {
////                setSupportActionBar(provideToolbar)
////            }
//        }
    }
}