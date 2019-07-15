package com.codeerow.spirit.mvvm.viewmodel

import com.codeerow.spirit.mvvm.command.ViewCommand
import com.codeerow.spirit.mvvm.command.exception.ExceptionCommand
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable


/**
 * ViewModel implementation for MVVM pattern.
 * View can subscribe for ViewModel for observing
 * commands ViewModel emits.
 * */
abstract class MvvmViewModel : RxViewModel() {

    var bus: PublishRelay<ViewCommand> = PublishRelay.create()


    /**
     * Subscription utils. Holds disposables and clears them when ViewModel
     * destroying.
     * */
    fun <T : Any?> Single<T>.subscribeByViewModel(onNext: (T) -> Unit = {}): Disposable {
        return this.subscribe(onNext) { postException(it) }
                .bindToLifecycle()
    }

    fun Completable.subscribeByViewModel(onComplete: () -> Unit = {}): Disposable {
        return this.subscribe(onComplete) { postException(it) }
                .bindToLifecycle()
    }

    fun <T : Any?> Observable<T>.subscribeByViewModel(onComplete: (T) -> Unit = {}): Disposable {
        return this.subscribe(onComplete) { postException(it) }
                .bindToLifecycle()
    }


    /**
     * Emits Exception bus for subscribed views.
     * */
    fun postException(throwable: Throwable) {
        bus.accept(ExceptionCommand(throwable))
    }
}