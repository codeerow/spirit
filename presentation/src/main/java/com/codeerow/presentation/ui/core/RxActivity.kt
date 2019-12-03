package com.codeerow.presentation.ui.core

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class RxActivity : AppCompatActivity() {


    /**
     * Holds view disposables. Clears it on onDestroy.
     * */
    private val lifecycleDisposables = CompositeDisposable()


    override fun onDestroy() {
        lifecycleDisposables.clear()
        super.onDestroy()
    }

    /**
     * Binds disposables to lifecycle disposables.
     * */
    private fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }


    /**
     *  Subscribe utils. Clears disposables on onDestroy.
     * */
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