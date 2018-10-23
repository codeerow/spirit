package com.codeerow.pandora.box.common.dispatcher

//import com.codeerow.pandora.box.common.handler.EventHandler


//class EventDispatcher<T : Event<*>, HANDLER : EventHandler<T>> {
//    fun dispatch(fragment: Fragment, event: T) {
//        (fragment as? HANDLER)?.handle(event)?.also { return }
//        fragment.parentFragment?.let { dispatch(it, event) }?.also { return }
//                ?: dispatchEventOnActivity(fragment.requireActivity(), event)
//    }
//
//    private fun dispatchEventOnActivity(activity: FragmentActivity, event: T) {
//        (activity as? HANDLER)?.handle(event)
//                ?: throw IllegalStateException("Parent activity ${activity.localClassName} should implement handler for this event ${event::class.java.simpleName}")
//    }
//}