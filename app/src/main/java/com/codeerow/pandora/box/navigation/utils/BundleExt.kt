package com.codeerow.pandora.box.navigation.utils

import android.os.Bundle
import com.codeerow.pandora.box.navigation.entity.UIConfiguration


var Bundle?.uiConfiguration: UIConfiguration?
    set(value) {
        this?.putSerializable("uiConfiguration", value)
    }
    get() {
        return this?.getSerializable("uiConfiguration") as UIConfiguration?
    }


var Bundle?.startDestination: Int?
    set(value) {
        this?.putInt("startDestination", value ?: 0)
    }
    get() {
        val value = this?.getInt("startDestination")
        return if (value == 0) null
        else value
    }
