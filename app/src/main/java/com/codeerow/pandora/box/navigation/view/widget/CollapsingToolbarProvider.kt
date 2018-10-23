package com.codeerow.pandora.box.navigation.view.widget

import android.support.design.widget.CollapsingToolbarLayout


interface CollapsingToolbarProvider {
    var collapsingToolbar: CollapsingToolbarLayout
    //    var provideToolbar: Toolbar
    //    var nestedScrollView: NestedScrollView


    fun handleUIConfiguration(configure: CollapsingToolbarLayout.() -> Unit) {
        configure.invoke(collapsingToolbar)
//        property.isShown?.let(::showOrHide)
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