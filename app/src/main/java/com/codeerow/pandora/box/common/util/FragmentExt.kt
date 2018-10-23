package com.codeerow.pandora.box.common.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.util.Log


inline fun <reified T : ViewModel> Fragment.provideViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val vm = ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.provideParentFragmentViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val parent = parentFragment ?: let {
        Log.w("MvvmBox", "${this::class.simpleName} has no parent fragment, his own entity of viewmodel will be used instead.")
        this
    }
    val vm = ViewModelProviders.of(parent, viewModelFactory)[T::class.java]
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.provideActivityViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val vm = ViewModelProviders.of(requireActivity(), viewModelFactory)[T::class.java]
    vm.body()
    return vm
}