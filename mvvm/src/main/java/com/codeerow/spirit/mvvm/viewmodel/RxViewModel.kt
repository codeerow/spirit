package com.codeerow.spirit.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Adds methods and extensions for clearing disposables for ViewModel lifecycle.
 * */
abstract class RxViewModel : ViewModel() {
    val lifecycleDisposables = CompositeDisposable()


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
}