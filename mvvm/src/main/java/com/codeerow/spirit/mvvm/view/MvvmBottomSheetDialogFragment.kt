package com.codeerow.spirit.mvvm.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.codeerow.spirit.mvvm.command.exception.ExceptionHandler
import com.codeerow.spirit.mvvm.view.extensions.provideParentFragmentViewModel
import com.codeerow.spirit.mvvm.view.extensions.provideSharedViewModel
import com.codeerow.spirit.mvvm.view.extensions.provideViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * This fragment has list of ViewModels. By default it is subscribed for ViewModels. If you not
 * interesting in commands that ViewModels emit override isViewModelEventsAttached.
 * Provide ViewModels for this view lazily like this:
 * private val viewModel by lazy { provideViewModel<AnyViewModel>() } if you
 * inject ViewModel.
 * */
abstract class MvvmBottomSheetDialogFragment : BottomSheetDialogFragment(), MvvmView, ExceptionHandler {

    /**
     * Determines if Fragment will be subscribed for ViewModels commands.
     * If true - activity subscribed for commands.
     * */
    open val isViewModelEventsAttached = true

    /**
     * Needed for disposing old commands subscriptions. If not to dispose old
     * subscriptions there will be a lot of duplicated subscriptions.
     * */
    private val subscribeDisposable = CompositeDisposable()


    /**
     * Holds view disposables. Clears it on onDestroyView.
     * */
    override val lifecycleDisposables = CompositeDisposable()


    /* Lifecycle */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeDisposable.clear()
        if (isViewModelEventsAttached) {
            viewModel?.bus?.observeOn(AndroidSchedulers.mainThread())?.subscribeByView { it.execute(this) }?.let(subscribeDisposable::add)
        }
    }

    override fun onDestroyView() {
        lifecycleDisposables.clear()
        super.onDestroyView()
    }


    /**
     *  ViewModels provide utils
     * */
    inline fun <reified VM : ViewModel> androidx.fragment.app.Fragment.provideViewModel(body: VM.() -> Unit = {}): VM {
        return provideViewModel(viewModelFactory, body)
    }

    inline fun <reified VM : ViewModel> androidx.fragment.app.Fragment.provideActivityViewModel(body: VM.() -> Unit = {}): VM {
        return provideSharedViewModel(viewModelFactory, body)
    }

    inline fun <reified VM : ViewModel> androidx.fragment.app.Fragment.provideParentFragmentViewModel(body: VM.() -> Unit = {}): VM {
        return provideParentFragmentViewModel(viewModelFactory, body)
    }


    /**
     *  Takes parent (activity/parentFragment) ViewModel that implements
     *  specified interface. For example you need some functionality on view
     *  like InputCodePresentation. Then implement this presentation on Activity's
     *  or Fragment's ViewModel and start child fragment from it. Child fragment
     *  will find implementation and use it when you need. It give opportunity for
     *  making different ViewModels with different implementations of same functionality
     *  and reuse Fragments.
     * */
    inline fun <reified VM> takeViewModel(): VM {
        var currentParentFragment = parentFragment
        var presentation: VM? = null
        while (currentParentFragment != null && presentation == null) {
            presentation = (currentParentFragment as? MvvmView)?.viewModel as? VM
            if (presentation == null) currentParentFragment = currentParentFragment.parentFragment
        }
        if (presentation == null) presentation = (activity as? MvvmView)?.viewModel as? VM
        return presentation ?: throw IllegalStateException()
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