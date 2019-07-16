package com.codeerow.spirit.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codeerow.spirit.mvvm.command.exception.ExceptionHandler
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * This activity has list of ViewModels. By default it is subscribed for ViewModels. If you not
 * interesting in commands that ViewModels emit override isViewModelEventsAttached.
 * Provide ViewModels for this view lazily like this:
 * private val viewModel by lazy { provideViewModel<AnyViewModel>() } if you
 * inject ViewModel.
 * */
abstract class MvvmActivity : AppCompatActivity(), MvvmView, ExceptionHandler {

    /**
     * Determines if Activity will be subscribed for ViewModels commands.
     * If true - activity subscribed for commands.
     * */
    open val isViewModelEventsAttached = true

    /**
     * Needed for disposing old commands subscriptions. If not to dispose old
     * subscriptions there will be a lot of duplicated subscriptions.
     * */
    private val subscribeDisposable = CompositeDisposable()


    /**
     * Holds view disposables. Clears it on onDestroy.
     * */
    override val lifecycleDisposables = CompositeDisposable()


    /**
     * Service method for inflating activity.
     * Set content view here.
     * */
    abstract fun inflateLayout()


    /* Lifecycle */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflateLayout()
        subscribeDisposable.clear()
        if (isViewModelEventsAttached) {
            viewModel?.bus?.observeOn(AndroidSchedulers.mainThread())?.subscribeByView { it.execute(this) }?.let(subscribeDisposable::add)
        }
    }

    override fun onDestroy() {
        lifecycleDisposables.clear()
        super.onDestroy()
    }


    /**
     *  Subscribe utils. Clears disposables on onDestroy.
     * */
    fun <T : Any?> Observable<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(it) }
                .bindToLifecycle()
    }


    fun <T : Any?> Single<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(it) }
                .bindToLifecycle()
    }


    fun <T : Any?> Maybe<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(it) }
                .bindToLifecycle()
    }


    fun Completable.subscribeByView(onNext: () -> Unit = {}): Disposable {
        return subscribe(onNext) { handle(it) }
                .bindToLifecycle()
    }
}