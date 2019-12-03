package com.codeerow.spirit.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Adds methods and extensions for clearing disposables for ViewModel lifecycle.
 * */
open class RxViewModel : ViewModel() {
    private val lifecycleDisposables = CompositeDisposable()


    /* Lifecycle */
    override fun onCleared() {
        super.onCleared()
        lifecycleDisposables.clear()
    }


    /* Extensions */
    fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }


    /**
     * Subscription utils. Holds disposables and clears them when ViewModel
     * destroying.
     * */
    fun <T : Any?> Single<T>.subscribeByViewModel(onNext: (T) -> Unit = {}): Disposable {
        return this.subscribe(onNext)
                .bindToLifecycle()
    }

    fun Completable.subscribeByViewModel(onComplete: () -> Unit = {}): Disposable {
        return this.subscribe(onComplete)
                .bindToLifecycle()
    }

    fun <T : Any?> Observable<T>.subscribeByViewModel(onComplete: (T) -> Unit = {}): Disposable {
        return this.subscribe(onComplete)
                .bindToLifecycle()
    }
}