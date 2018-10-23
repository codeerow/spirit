package com.codeerow.pandora.box.utils

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import org.greenrobot.eventbus.EventBus
import com.codeerow.pandora.box.common.provider.Event
import timber.log.Timber


internal val logErrorFunc = { throwable: Throwable -> Timber.e(throwable) }

fun <T : Any?> Flowable<T>.subscribeWithErrorLog(onNext: (T) -> Unit = {}) = subscribe(onNext, logErrorFunc)
fun <T : Any?> Observable<T>.subscribeWithErrorLog(onNext: (T) -> Unit = {}) = subscribe(onNext, logErrorFunc)
fun <T : Any?> Single<T>.subscribeWithErrorLog(onNext: (T) -> Unit = {}) = subscribe(onNext, logErrorFunc)
fun Completable.subscribeWithErrorLog(onComplete: () -> Unit = {}) = subscribe(onComplete, logErrorFunc)


fun Completable.withLoadingEvent(): Completable {
    return this.doOnSubscribe { EventBus.getDefault().post(Event.Loading(true)) }
}

fun <T> Single<T>.withLoadingEvent(): Single<T> {
    return this.doOnSubscribe { EventBus.getDefault().post(Event.Loading(true)) }
}