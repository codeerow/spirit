package com.codeerow.spirit.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.codeerow.spirit.core.command.exception.ExceptionHandler


interface Executor<I, O> {
    fun execute(input: I): O
}

class ExceptionDispatcher(private val handlers: MutableList<ExceptionHandler> = mutableListOf()) {

    fun attachHandler(exceptionHandler: ExceptionHandler) {
        handlers.add(exceptionHandler)
    }

    fun <T> attachLifecycleHandler(handler: T) where T : LifecycleOwner,
                                                     T : ExceptionHandler {
        val lifecycle = handler.lifecycle
        if(lifecycle.currentState == Lifecycle.State.DESTROYED) return


    }

    fun detachHandler(exceptionHandler: ExceptionHandler) {
        handlers.remove(exceptionHandler)
    }

    fun dispatch(throwable: Throwable) {
        handlers.forEach { it.handle(throwable) }
    }
}