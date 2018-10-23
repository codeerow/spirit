package com.codeerow.pandora.box.navigation.common.utils

import android.content.Context
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View?.hideKeyboard() {
    this?.context?.let {
        val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

fun FragmentManager.currentFragment(@IdRes containerViewId: Int): Fragment? {
    return findFragmentById(containerViewId)
}
