package com.codeerow.pandora.box.common.provider

import com.jakewharton.rxrelay2.PublishRelay


interface EventsProvider<CUSTOM_EVENTS : Any> {
    var event: PublishRelay<Event<CUSTOM_EVENTS>>
}


sealed class Event<out CUSTOM : Any>(val responderTag: String?) {
    class Exception(val throwable: Throwable, responderTag: String? = null) : Event<Nothing>(responderTag)
    class Loading(val isEnabled: Boolean, responderTag: String? = null) : Event<Nothing>(responderTag)
    class Segue(val segue: com.codeerow.pandora.box.navigation.entity.Segue, val forGraph: Int? = null) : Event<Nothing>(null)
//    class UpdateUI(val uiConfiguration: UIConfiguration? = null, responderTag: String? = null) : Event<Nothing>(responderTag)
    class Custom<CUSTOM : Any>(val data: CUSTOM) : Event<CUSTOM>(null)
}