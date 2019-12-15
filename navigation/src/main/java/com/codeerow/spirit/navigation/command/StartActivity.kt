package com.codeerow.spirit.navigation.command

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


class StartActivity(private val activity: Class<out FragmentActivity>,
                    private val finishCurrentActivity: Boolean = false,
                    private val forResult: Int? = null,
                    private val configureArgs: Bundle.() -> Unit = {}) : NavigationCommand() {

    override fun execute(fragment: Fragment) {
        val currentActivity = fragment.requireActivity()
        val intent = configureIntent(currentActivity)
        forResult?.let { fragment.startActivityForResult(intent, it) } ?: fragment.startActivity(intent)
        if (finishCurrentActivity) currentActivity.finish()
        handled = true
    }

    override fun execute(activity: FragmentActivity) {
        val intent = configureIntent(activity)
        forResult?.let { activity.startActivityForResult(intent, it) } ?: activity.startActivity(intent)
        if (finishCurrentActivity) activity.finish()
        handled = true
    }


    private fun configureIntent(currentActivity: FragmentActivity): Intent {
        val intent = Intent(currentActivity, activity)
        val arguments = Bundle()
        arguments.configureArgs()
        return intent.putExtras(arguments)
    }
}