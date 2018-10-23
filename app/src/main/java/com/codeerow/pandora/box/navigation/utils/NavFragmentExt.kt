package com.codeerow.pandora.box.navigation.utils

import android.os.Bundle
import com.codeerow.pandora.box.common.provider.Event
import com.codeerow.pandora.box.navigation.entity.Segue
import com.codeerow.pandora.box.navigation.entity.UIConfiguration
import com.codeerow.pandora.box.navigation.view.NavFragment


fun NavFragment.handle(event: Event.Segue) {
    performSegue(event.segue)
}


fun NavFragment.performSegue(segue: Segue) {
    when (segue) {
        is Segue.Forward -> goForward(this, segue)
        is Segue.Backward -> goBackward(this)
    }
}


private fun goForward(fragment: NavFragment, forward: Segue.Forward) {
    val bundle = Bundle()
    val uiConfiguration = fragment.navHostFragment.childFragmentManager.fragments.lastOrNull()?.arguments?.uiConfiguration?.clone()
            ?: UIConfiguration()
    forward.configureUI.invoke(uiConfiguration)
    forward.configureBundle.invoke(bundle)
    bundle.uiConfiguration = uiConfiguration
    fragment.navHostFragment.navController.navigate(forward.actionID, bundle)
}

private fun goBackward(fragment: NavFragment) {
    fragment.navHostFragment.navController.navigateUp()
}


fun NavFragment.performSegue(actionID: Int, configureBundle: Bundle.() -> Unit = {}, configureUI: UIConfiguration.() -> Unit = {}) {
    val bundle = Bundle()
    val uiConfiguration = this.navHostFragment.childFragmentManager.fragments.lastOrNull()?.arguments?.uiConfiguration?.clone()
            ?: UIConfiguration()
    configureUI.invoke(uiConfiguration)
    configureBundle.invoke(bundle)
    bundle.uiConfiguration = uiConfiguration
    this.navHostFragment.navController.navigate(actionID, bundle)
}