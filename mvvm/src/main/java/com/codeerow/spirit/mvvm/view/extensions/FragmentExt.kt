package com.codeerow.spirit.mvvm.view.extensions

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.codeerow.spirit.mvvm.view.MvvmView


/**
 * Provides ViewModel for fragment in this fragment scope
 * */
inline fun <reified T : ViewModel> Fragment.provideViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val vm = ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    vm.body()
    return vm
}


/**
 * Provides ViewModel for fragment in its parent fragment scope.
 * For example: You can provide AViewModel for FragmentA and start DialogA from this
 * fragment. In this case if you provide for DialogA with provideParentFragmentViewModel then
 * you provide the same ViewModel that FragmentA has.
 * */
inline fun <reified T : ViewModel> Fragment.provideParentFragmentViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val parent = parentFragment ?: let {
        Log.w("MvvmBox", "${this::class.simpleName} has no parent fragment, his own entity of viewmodel will be used instead.")
        this
    }
    val vm = ViewModelProviders.of(parent, viewModelFactory)[T::class.java]
    vm.body()
    return vm
}


/**
 * Provides ViewModel for fragment in its parent activity scope.
 * For example: You can provide SharedViewModel for FragmentA with provideSharedViewModel and
 * provide SharedViewModel ViewModel for FragmentB with provideSharedViewModel. In this case
 * you provide the same ViewModel for these fragments.
 * */
inline fun <reified T : ViewModel> Fragment.provideSharedViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val vm = ViewModelProviders.of(requireActivity(), viewModelFactory)[T::class.java]
    vm.body()
    return vm
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
inline fun <reified VM> Fragment.takeViewModel(): VM {
    var currentParentFragment = parentFragment
    var presentation: VM? = null
    while (currentParentFragment != null && presentation == null) {
        presentation = (currentParentFragment as? MvvmView)?.viewModel as? VM
        if (presentation == null) currentParentFragment = currentParentFragment.parentFragment
    }
    if (presentation == null) presentation = (activity as? MvvmView)?.viewModel as? VM
    return presentation ?: throw IllegalStateException()
}