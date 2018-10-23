package com.codeerow.pandora.box.mvvm.view.rx

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class RxFragment : Fragment() {
    private val lifecycleDisposables = CompositeDisposable()


    override fun onDestroyView() {
        lifecycleDisposables.clear()
        super.onDestroyView()
    }

    fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }
}