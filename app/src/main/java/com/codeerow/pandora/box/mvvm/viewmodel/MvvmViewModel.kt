package com.codeerow.pandora.box.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.jakewharton.rxrelay2.PublishRelay
import com.codeerow.pandora.box.common.provider.Event
import com.codeerow.pandora.box.common.provider.EventsProvider
import com.codeerow.pandora.box.common.provider.ViewState
import com.codeerow.pandora.box.common.provider.ViewStateProvider
import com.codeerow.pandora.box.navigation.entity.Segue
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable


abstract class MvvmViewModel<VIEW_STATE : Any, EVENTS : Any> : RxViewModel(),
        EventsProvider<EVENTS>,
        ViewStateProvider<VIEW_STATE> {
    override var viewState = MutableLiveData<ViewState<VIEW_STATE>>()
    override var event: PublishRelay<Event<EVENTS>> = PublishRelay.create()


    fun <T : Any?> Single<T>.subscribeByViewModel(onNext: (T) -> Unit = {}): Disposable {
        return this.doFinally { event.accept(Event.Loading(false)) }
                .subscribe(onNext) { postException(it) }
                .bindToLifecycle()
    }


    fun Completable.subscribeByViewModel(onComplete: () -> Unit = {}): Disposable {
        return this.doFinally { event.accept(Event.Loading(false)) }
                .subscribe(onComplete) { postException(it) }
                .bindToLifecycle()
    }


    fun <T : Any?> Observable<T>.subscribeByViewModel(onComplete: (T) -> Unit = {}): Disposable {
        return this.doFinally { event.accept(Event.Loading(false)) }
                .subscribe(onComplete) { postException(it) }
                .bindToLifecycle()
    }


    fun postException(throwable: Throwable) {
        event.accept(Event.Exception(throwable))
    }

    fun performSegue(segue: Segue, forGraph: Int? = null) {
        event.accept(Event.Segue(segue, forGraph))
    }
//
//    fun notifyUIChanged(uiConfiguration: UIConfiguration) {
//        event.accept(Event.UpdateUI(uiConfiguration))
//    }
}