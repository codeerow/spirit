package com.codeerow.pandora.box.navigation.entity

import android.os.Bundle



sealed class Segue {
    data class Forward(val actionID: Int, val configureBundle: Bundle.() -> Unit = {}, val configureUI: UIConfiguration.() -> Unit = {}) : Segue()
    object Backward : Segue()
}