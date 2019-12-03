package com.codeerow.presentation.ui.core

import androidx.fragment.app.Fragment
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class RxFragment : Fragment() {

    /**
     * Holds view disposables. Clears it on onDestroyView.
     * */
    private val lifecycleDisposables = CompositeDisposable()


    /**
     * Binds disposables to lifecycle disposables.
     * */
    private fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }

    fun <T : Any?> Observable<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext)
                .bindToLifecycle()
    }


    fun <T : Any?> Single<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext)
                .bindToLifecycle()
    }


    fun <T : Any?> Maybe<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext)
                .bindToLifecycle()
    }


    fun Completable.subscribeByView(onNext: () -> Unit = {}): Disposable {
        return subscribe(onNext)
                .bindToLifecycle()
    }
}