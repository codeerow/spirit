package com.codeerow.spirit.navigation.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.codeerow.spirit.navigation.Router

fun <R : Router> Fragment.attachRouter(router: R) {
    router.navigationBus.observe(this, Observer { command ->
        command.execute(this)
    })
}