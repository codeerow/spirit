package com.codeerow.presentation.ui.base

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import com.codeerow.spirit.mvvm.view.MvvmDialogFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


abstract class BaseMvvmDialogFragment : MvvmDialogFragment() {

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        // This is called even for API levels below 23.
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
