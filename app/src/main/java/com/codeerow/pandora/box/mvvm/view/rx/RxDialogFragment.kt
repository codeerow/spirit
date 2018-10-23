package com.codeerow.pandora.box.mvvm.view.rx

import android.support.v4.app.DialogFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class RxDialogFragment : DialogFragment() {
    private val lifecycleDisposables = CompositeDisposable()


    /* Lifecycle */
    override fun onDestroyView() {
        lifecycleDisposables.clear()
        super.onDestroyView()
    }

    fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }
}