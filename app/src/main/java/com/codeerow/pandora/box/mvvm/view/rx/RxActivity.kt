package com.codeerow.pandora.box.mvvm.view.rx

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class RxActivity : AppCompatActivity() {
    private val lifecycleDisposables = CompositeDisposable()


    /* Lifecycle */
    override fun onDestroy() {
        lifecycleDisposables.clear()
        super.onDestroy()
    }

    fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }
}