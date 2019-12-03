package com.codeerow.spirit.navigation.command

import androidx.fragment.app.Fragment
import com.codeerow.spirit.navigation.view.NavigationProvider


abstract class GoBackward<T : NavigationProvider> : NavigationCommand() {

    override fun execute(fragment: Fragment) {
        val navigationProvider = fragment as? T
        handled = handleFragment(navigationProvider)
        if (!handled) dispatchOnParent(fragment)
    }

    private fun dispatchOnParent(fragment: Fragment) {
        fragment.parentFragment?.let(::execute)
            ?: execute(fragment.requireActivity())
    }

    abstract fun handleFragment(navigationProvider: T?): Boolean
}