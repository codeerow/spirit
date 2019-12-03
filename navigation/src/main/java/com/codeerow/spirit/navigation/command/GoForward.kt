package com.codeerow.spirit.navigation.command

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.codeerow.spirit.navigation.view.NavigationProvider


abstract class GoForward<T : NavigationProvider> : NavigationCommand() {

    override fun execute(fragment: Fragment) {
        val navigationProvider = fragment as? T
        handled = handle(navigationProvider)
        if (!handled) dispatchOnParent(fragment)
    }

    private fun dispatchOnParent(fragment: Fragment) {
        fragment.parentFragment?.let(::execute)
                ?: execute(fragment.requireActivity())
    }

    override fun execute(activity: FragmentActivity) {
        val navigationProvider = activity as? T
        handled = handle(navigationProvider)
        check(handled) { "Parent activity ${activity.localClassName} should implement handler for this command ${this::class.java.simpleName}" }
    }

    abstract fun handle(navigationProvider: T?): Boolean
}
