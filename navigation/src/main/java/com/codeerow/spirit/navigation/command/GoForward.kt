package com.codeerow.spirit.navigation.command

import com.codeerow.spirit.navigation.view.NavigationProvider


abstract class GoForward<T : NavigationProvider> : NavigationCommand() {

    override fun execute(fragment: androidx.fragment.app.Fragment) {
        val navigationProvider = fragment as? T
        val handled = handle(navigationProvider)
        if (!handled) dispatchOnParent(fragment)
    }

    private fun dispatchOnParent(fragment: androidx.fragment.app.Fragment) {
        fragment.parentFragment?.let(::execute)
            ?: execute(fragment.requireActivity())
    }

    override fun execute(activity: androidx.fragment.app.FragmentActivity) {
        val navigationProvider = activity as? T
        val handled = handle(navigationProvider)
        if (!handled) throw IllegalStateException("Parent activity ${activity.localClassName} should implement handler for this command ${this::class.java.simpleName}")
    }

    abstract fun handle(navigationProvider: T?): Boolean
}
