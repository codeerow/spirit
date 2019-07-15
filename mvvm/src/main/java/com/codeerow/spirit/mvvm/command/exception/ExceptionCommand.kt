package com.codeerow.spirit.mvvm.command.exception

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.codeerow.spirit.mvvm.command.ViewCommand


/**
 * ViewCommand reports view that exception was occurred somewhere in MvvmViewModel.
 * ViewCommand will execute if view implements ExceptionHandler.
 * @param throwable exception that occurred
 *
 * @throws IllegalStateException if there is no view that implements ExceptionHandler
 * @see ExceptionHandler
 * */
class ExceptionCommand(private val throwable: Throwable) : ViewCommand() {

    override fun execute(fragment: Fragment) {
        val handler = fragment as? ExceptionHandler
        val handled = handler?.handle(this.throwable)
        if (handled == true) return
        else dispatchOnParent(fragment)
    }

    private fun dispatchOnParent(fragment: Fragment) {
        fragment.parentFragment?.let { execute(it) }
                ?: dispatchOnActivity(fragment.requireActivity())
    }


    private fun dispatchOnActivity(activity: FragmentActivity) {
        (activity as? ExceptionHandler)?.handle(this.throwable)
                ?: throw IllegalStateException("Parent activity ${activity.localClassName} should implement handler for this command ${this::class.java.simpleName}")
    }
}