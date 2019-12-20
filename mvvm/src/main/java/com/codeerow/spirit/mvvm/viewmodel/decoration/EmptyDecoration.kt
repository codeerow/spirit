package com.codeerow.spirit.mvvm.viewmodel.decoration

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable


class EmptyDecoration : SubscriptionDecoration {
    override fun <T> Maybe<T>.subscribeDecorated(onSuccess: (T) -> Unit): Disposable = this.subscribe(onSuccess)

    override fun <T> Single<T>.subscribeDecorated(onSuccess: (T) -> Unit): Disposable = this.subscribe(onSuccess)

    override fun Completable.subscribeDecorated(onComplete: () -> Unit): Disposable = this.subscribe(onComplete)

    override fun <T> Observable<T>.subscribeDecorated(onNext: (T) -> Unit): Disposable = this.subscribe(onNext)
}

