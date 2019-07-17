package com.codeerow.spirit.mvvm.view

import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


interface MvvmView {

    /**
     * List of ViewModels for view. Needed for subscribing for
     * ViewModels commands on view.
     * */
    val viewModel: MvvmViewModel?


    /**
     * Holds view disposables. Clears it on onDestroyView.
     * */
    val lifecycleDisposables: CompositeDisposable


    /**
     * Binds disposables to lifecycle disposables.
     * */
    fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }
}