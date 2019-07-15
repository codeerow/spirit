package com.codeerow.spirit.box.utils

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager


/* Keyboard */
fun View?.hideKeyboard(removeFocusable: Boolean = false) {
    this?.context?.let {
        if (removeFocusable) this.isFocusable = false
        val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}


fun View.showKeyboard() {
    if (!isFocusableInTouchMode) isFocusableInTouchMode = true
    this.requestFocus()
    val im = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    im.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}


/* View group */
fun View?.visible() {
    this?.visibility = View.VISIBLE
}

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View?.invisible() {
    this?.visibility = View.INVISIBLE
}


/* Common */
val View.inflater: LayoutInflater
    get() = LayoutInflater.from(context)


val Any.classTag: String
    get() = this::class.java.simpleName

fun statusBarHeightDp(context: Context): Int {
    var result = 0
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = context.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun actionBarHeightDp(context: Context): Int {
    val resources = context.resources
    val id = resources.getIdentifier(if (android.R.attr.orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_height_landscape", "dimen", "android")
    return if (id > 0) {
        resources.getDimensionPixelSize(id)
    } else 0
}