package com.codeerow.spirit.navigation.command


class FinishActivity(private val withResult: Int? = null) : NavigationCommand() {

    override fun execute(fragment: androidx.fragment.app.Fragment) = handle(fragment.requireActivity())
    override fun execute(activity: androidx.fragment.app.FragmentActivity) = handle(activity)


    private fun handle(currentActivity: androidx.fragment.app.FragmentActivity) {
        withResult?.let { currentActivity.setResult(withResult) }
        currentActivity.finish()
        handled = true
    }
}