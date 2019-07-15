package com.codeerow.spirit.navigation.command

import android.content.Intent
import android.os.Bundle


class StartActivity(private val activity: Class<out androidx.fragment.app.FragmentActivity>,
                    private val finishCurrentActivity: Boolean = false,
                    private val forResult: Int? = null,
                    private val configureArgs: Bundle.() -> Unit = {}) : NavigationCommand() {

    override fun execute(fragment: androidx.fragment.app.Fragment) = handle(fragment.requireActivity())
    override fun execute(activity: androidx.fragment.app.FragmentActivity) = handle(activity)


    private fun handle(currentActivity: androidx.fragment.app.FragmentActivity) {
        val intent = Intent(currentActivity, activity)
        val arguments = Bundle()
        arguments.configureArgs()
        intent.putExtras(arguments)
        forResult?.let { currentActivity.startActivityForResult(intent, it) }
                ?: currentActivity.startActivity(intent)
        if (finishCurrentActivity) currentActivity.finish()
    }
}