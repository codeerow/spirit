package com.codeerow.spirit.navigation.view


/**
 *  Return true if back was handled, otherwise return false and it will be handled by parent
 * */
interface BackPressedDelegate {
    fun onBackPressed(): Boolean = false
}