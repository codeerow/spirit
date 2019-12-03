package com.codeerow.spirit.core.command

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * ViewCommand that MvvmViewModel emits. We need different executions (for fragment and activity
 * in this situation) because MvvmViewModel emits command to the view that owns this MvvmViewModel
 * if there are multiple views that subscribed for MvvmViewModel command then there will be
 * multiple executions of command, but you can specify for view if it subscribed for commands.
 * */
abstract class ViewCommand {

    /**
     * Execution for Fragment
     * */
    abstract fun execute(fragment: Fragment)

    /**
     * Execution for Activity
     * */
    open fun execute(activity: FragmentActivity) {}
}