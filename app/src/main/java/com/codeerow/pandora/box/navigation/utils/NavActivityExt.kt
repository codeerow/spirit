package com.codeerow.pandora.box.navigation.utils

import android.os.Bundle
import com.codeerow.pandora.box.common.provider.Event
import com.codeerow.pandora.box.navigation.entity.Segue
import com.codeerow.pandora.box.navigation.view.NavMvvmActivity


fun NavMvvmActivity<*, *, *>.handle(event: Event.Segue) {
    performSegue(event.segue)
}


fun NavMvvmActivity<*, *, *>.performSegue(segue: Segue) {
    when (segue) {
        is Segue.Forward -> goForward(this, segue)
        is Segue.Backward -> goBackward(this)
    }
}


private fun goForward(activity: NavMvvmActivity<*, *, *>, forward: Segue.Forward) {
    val bundle = Bundle()
    forward.configureBundle.invoke(bundle)
    activity.navHostFragment.navController.navigate(forward.actionID, bundle)
}

private fun goBackward(activity: NavMvvmActivity<*, *, *>) {
    activity.navHostFragment.navController.navigateUp()
}