package com.codeerow.spirit.mvvm.view.extensions

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


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
