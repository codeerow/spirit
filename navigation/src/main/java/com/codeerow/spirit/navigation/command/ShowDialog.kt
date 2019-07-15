package com.codeerow.spirit.navigation.command

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.codeerow.spirit.box.utils.classTag


class ShowDialog(private val dialog: DialogFragment,
                 private val style: Pair<Int, Int>? = null, // style to theme (ex: DialogFragment.STYLE_NORMAL to R.style.Dialog_Fullscreen)
                 private val configureBundle: Bundle.() -> Unit = {}) : NavigationCommand() {


    override fun execute(fragment: Fragment) = showDialog(fragment.childFragmentManager)

    override fun execute(activity: androidx.fragment.app.FragmentActivity) = showDialog(activity.supportFragmentManager)


    private fun showDialog(childFragmentManager: androidx.fragment.app.FragmentManager) {
        val bundle = Bundle()
        style?.let { dialog.setStyle(it.first, it.second) }
        bundle.configureBundle()
        dialog.arguments = bundle
        dialog.show(childFragmentManager, dialog.classTag)
    }
}