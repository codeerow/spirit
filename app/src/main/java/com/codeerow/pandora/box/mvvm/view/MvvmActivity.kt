package com.codeerow.pandora.box.mvvm.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codeerow.pandora.box.common.handler.ExceptionHandler
import com.codeerow.pandora.box.common.handler.LoadingEventHandler
import com.codeerow.pandora.box.common.provider.Event
import com.codeerow.pandora.box.common.util.provideViewModel
import com.codeerow.pandora.box.mvvm.view.rx.RxActivity
import com.codeerow.pandora.box.mvvm.viewmodel.MvvmViewModel
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable


abstract class MvvmActivity<VS : Any, E : Any, VM : MvvmViewModel<VS, E>> : RxActivity(),
        LoadingEventHandler, ExceptionHandler {

    abstract var viewModelFactory: ViewModelProvider.Factory
    abstract val viewModel: VM
    abstract val layoutResID: Int


    open fun updateViewState(viewState: VS) {}
    open fun handleEvent(it: Event.Custom<E>) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID)
        viewModel.viewState.observe(this, Observer {
            it?.customState?.let(::updateViewState)
        })
        viewModel.event.observeOn(AndroidSchedulers.mainThread())
                .subscribeByView {
                    when (it) {
                        is Event.Loading -> handle(it)
                        is Event.Exception -> handle(it)
//                        is Event.UpdateUI -> dispatch(it)
                        is Event.Custom<E> -> handleEvent(it)
                    }
                }
    }


    /**
     *  Subscribe utils
     * */
    fun <T : Any?> Observable<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(Event.Exception(it)) }
                .bindToLifecycle()
    }


    fun <T : Any?> Single<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(Event.Exception(it)) }
                .bindToLifecycle()
    }


    fun <T : Any?> Maybe<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(Event.Exception(it)) }
                .bindToLifecycle()
    }


    fun Completable.subscribeByView(onNext: () -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(Event.Exception(it)) }
                .bindToLifecycle()
    }


    /**
     *  ViewModels provide utils
     * */
    inline fun <reified VM : ViewModel> AppCompatActivity.provideViewModel(body: VM.() -> Unit = {}): VM {
        return provideViewModel(viewModelFactory, body)
    }
}