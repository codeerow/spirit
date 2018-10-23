package com.codeerow.pandora.box.navigation.utils

import android.support.v4.app.FragmentTransaction


fun FragmentTransaction.andThen(block: () -> Unit): FragmentTransaction {
    block()
    return this
}

fun FragmentTransaction.ifThen(condition: Boolean, block: FragmentTransaction.() -> Unit): FragmentTransaction {
    if (condition) this.block()
    return this
}