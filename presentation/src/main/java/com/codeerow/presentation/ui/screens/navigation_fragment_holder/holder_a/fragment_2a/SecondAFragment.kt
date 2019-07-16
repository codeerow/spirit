package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_2a.*
import org.koin.android.viewmodel.ext.android.viewModel


class SecondAFragment : MvvmFragment() {

    override val viewModel by viewModel<SecondAViewModel>()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_2a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxView.clicks(btnNavigateHolderB)
                .subscribeByView { viewModel.navigateToHolderB() }
    }
}