package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_1a.*
import org.koin.android.viewmodel.ext.android.viewModel


class FirstAFragment : MvvmFragment() {

    override val viewModel by viewModel<FirstAViewModel>()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_1a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxView.clicks(buttonNavigateSecond)
                .subscribeByView { viewModel.navigateSecondA() }
    }
}