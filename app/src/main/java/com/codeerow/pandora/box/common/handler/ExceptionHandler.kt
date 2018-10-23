package com.codeerow.pandora.box.common.handler

import android.util.Log
import com.codeerow.pandora.box.common.provider.Event


/**
 *  Return true if back was handled, otherwise return false and it will be handled by parent
 * */
interface ExceptionHandler {
    fun handle(event: Event.Exception) {
        Log.e("DEFAULT HANDLER", "Exception", event.throwable)
    }
}