package com.codeerow.pandora.box.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager


/* Keyboard */
fun View?.hideKeyboard(removeFocusable: Boolean) {
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
