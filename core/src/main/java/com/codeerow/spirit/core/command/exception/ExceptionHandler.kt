package com.codeerow.spirit.core.command.exception

import android.util.Log

/**
 * Handler for exception command
 * */
interface ExceptionHandler {

    /**
     *  @return true if back was handled, otherwise return false and it will be handled by parent
     * */
    fun handle(throwable: Throwable): Boolean {
        Log.e("Exception handler", "default handler", throwable)
        return false
    }//
}