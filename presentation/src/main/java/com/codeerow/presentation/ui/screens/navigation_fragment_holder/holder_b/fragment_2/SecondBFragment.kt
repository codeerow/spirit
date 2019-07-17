package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.MvvmFragment
import org.koin.android.viewmodel.ext.android.viewModel


class SecondBFragment : MvvmFragment() {

    override val viewModel by viewModel<SecondBViewModel>()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_2b, container, false)
    }
}