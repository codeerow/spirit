package com.codeerow.presentation.ui.screens.fragment_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_b.*
import org.koin.android.viewmodel.ext.android.viewModel


class BFragment : MvvmFragment() {

    override val viewModel by viewModel<BViewModel>()


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxView.clicks(btnNavigateC)
                .subscribeByView { viewModel.navigateC() }

        RxView.clicks(btnNavigateF)
                .subscribeByView { viewModel.navigateF() }

        RxView.clicks(btnSelectItem)
                .subscribeByView { viewModel.selectItem() }

        configureSelectedItem()
    }


    /** configurations */
    private fun configureSelectedItem() {
        viewModel.selectedItem.observe(this, Observer {
            tvSelectedItem.text = it
        })
    }
}