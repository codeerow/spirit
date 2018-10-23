package com.codeerow.pandora.box.mvvm.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import com.codeerow.pandora.box.common.handler.ExceptionHandler
import com.codeerow.pandora.box.common.handler.LoadingEventHandler
import com.codeerow.pandora.box.common.provider.Event
import com.codeerow.pandora.box.common.util.provideActivityViewModel
import com.codeerow.pandora.box.common.util.provideParentFragmentViewModel
import com.codeerow.pandora.box.common.util.provideViewModel
import com.codeerow.pandora.box.mvvm.view.rx.RxFragment
import com.codeerow.pandora.box.mvvm.viewmodel.MvvmViewModel
import com.codeerow.pandora.box.navigation.utils.handle
import com.codeerow.pandora.box.navigation.view.NavFragment
import com.codeerow.pandora.box.navigation.view.NavMvvmActivity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable


abstract class MvvmFragment<VS : Any, E : Any, VM : MvvmViewModel<VS, E>> : RxFragment() {

    abstract var viewModelFactory: ViewModelProvider.Factory
    abstract val viewModel: VM

//    private val exceptionDispatcher = EventDispatcher<Event.Exception, ExceptionHandler>()
//    private val loadingDispatcher = EventDispatcher<Event.Loading, LoadingEventHandler>()
//    private val segueDispatcher = EventDispatcher<Event.Segue, SegueHandler>()


    open fun updateViewState(viewState: VS) {}
    open fun handleEvent(it: Event.Custom<E>) {}


    /* Lifecycle */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(this, Observer {
            it?.customState?.let(::updateViewState)
        })
        viewModel.event.observeOn(AndroidSchedulers.mainThread())
                .subscribeByView {
                    when (it) {
                        is Event.Segue -> dispatch(this, it)
                        is Event.Loading -> dispatch(this, it)
                        is Event.Exception -> dispatch(this, it)
//                        is Event.UpdateUI -> dispatch(this, it)
                        is Event.Custom<E> -> handleEvent(it)
                    }
                }
    }


    /**
     *  Subscribe utils
     * */
    fun <T : Any?> Observable<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { dispatch(this@MvvmFragment, Event.Exception(it)) }
                .bindToLifecycle()
    }


    fun <T : Any?> Single<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { dispatch(this@MvvmFragment, Event.Exception(it)) }
                .bindToLifecycle()
    }


    fun <T : Any?> Maybe<T>.subscribeByView(onNext: (T) -> Unit = {}): Disposable {
        return subscribe(onNext) { dispatch(this@MvvmFragment, Event.Exception(it)) }
                .bindToLifecycle()
    }


    fun Completable.subscribeByView(onNext: () -> Unit = {}): Disposable {
        return subscribe(onNext) { dispatch(this@MvvmFragment, Event.Exception(it)) }
                .bindToLifecycle()
    }


    /**
     *  ViewModels provide utils
     * */
    inline fun <reified VM : ViewModel> Fragment.provideViewModel(body: VM.() -> Unit = {}): VM {
        return provideViewModel(viewModelFactory, body)
    }

    inline fun <reified VM : ViewModel> Fragment.provideActivityViewModel(body: VM.() -> Unit = {}): VM {
        return provideActivityViewModel(viewModelFactory, body)
    }

    inline fun <reified VM : ViewModel> Fragment.provideParentFragmentViewModel(body: VM.() -> Unit = {}): VM {
        return provideParentFragmentViewModel(viewModelFactory, body)
    }


    fun dispatch(fragment: Fragment, event: Event.Segue) {
        (fragment as? NavFragment)?.let { handler ->
            if (event.forGraph != null && handler.navHostFragment.navController.graph.id != event.forGraph) {
                fragment.parentFragment?.let { dispatch(it, event) }?.also { return }
                        ?: dispatchEventOnActivity(requireActivity(), event).also { return }
            } else handler.handle(event).also { return }
        }
        fragment.parentFragment?.let { dispatch(it, event) }?.also { return }
                ?: dispatchEventOnActivity(fragment.requireActivity(), event)
    }

    private fun dispatchEventOnActivity(activity: FragmentActivity, event: Event.Segue) {
        (activity as? NavMvvmActivity<*, *, *>)?.handle(event)
                ?: throw IllegalStateException("Parent activity ${activity.localClassName} should implement handler for this event ${event::class.java.simpleName}")
    }


    fun dispatch(fragment: Fragment, event: Event.Loading) {
        (fragment as? LoadingEventHandler)?.handle(event)?.also { return }
        fragment.parentFragment?.let { dispatch(it, event) }?.also { return }
                ?: dispatchEventOnActivity(fragment.requireActivity(), event)
    }

    private fun dispatchEventOnActivity(activity: FragmentActivity, event: Event.Loading) {
        (activity as? LoadingEventHandler)?.handle(event)
                ?: throw IllegalStateException("Parent activity ${activity.localClassName} should implement handler for this event ${event::class.java.simpleName}")
    }


    fun dispatch(fragment: Fragment, event: Event.Exception) {
        (fragment as? ExceptionHandler)?.handle(event)?.also { return }
        fragment.parentFragment?.let { dispatch(it, event) }?.also { return }
                ?: dispatchEventOnActivity(fragment.requireActivity(), event)
    }

    private fun dispatchEventOnActivity(activity: FragmentActivity, event: Event.Exception) {
        (activity as? ExceptionHandler)?.handle(event)
                ?: throw IllegalStateException("Parent activity ${activity.localClassName} should implement handler for this event ${event::class.java.simpleName}")
    }
}