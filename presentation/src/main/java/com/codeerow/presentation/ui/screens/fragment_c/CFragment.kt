package com.codeerow.presentation.ui.screens.fragment_c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_c.*
import org.koin.android.viewmodel.ext.android.viewModel


class CFragment : MvvmFragment() {

    override val viewModel by viewModel<CViewModel>()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxView.clicks(btnNavigateD)
                .subscribeByView { viewModel.navigateD() }

        RxView.clicks(btnNavigateE)
                .subscribeByView { viewModel.navigateE() }
    }
}