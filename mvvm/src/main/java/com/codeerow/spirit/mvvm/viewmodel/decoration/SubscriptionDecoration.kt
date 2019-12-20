package com.codeerow.spirit.mvvm.viewmodel.decoration

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable


interface SubscriptionDecoration {
    fun <T : Any?> Single<T>.subscribeDecorated(onSuccess: (T) -> Unit = {}): Disposable

    fun Completable.subscribeDecorated(onComplete: () -> Unit = {}): Disposable

    fun <T : Any?> Maybe<T>.subscribeDecorated(onSuccess: (T) -> Unit = {}): Disposable

    fun <T : Any?> Observable<T>.subscribeDecorated(onNext: (T) -> Unit = {}): Disposable
}