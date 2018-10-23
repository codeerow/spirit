package com.codeerow.pandora.box.common.handler

import com.codeerow.pandora.box.common.provider.Event


/**
 *  Return true if back was handled, otherwise return false and it will be handled by parent
 * */
interface LoadingEventHandler {
    fun handle(event: Event.Loading) {}
}