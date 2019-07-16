package com.codeerow.presentation.ui.screens.fragment_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.codeerow.presentation.R
import com.codeerow.presentation.databinding.FragmentBBinding
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_b.*
import org.koin.android.viewmodel.ext.android.viewModel


class BFragment : MvvmFragment() {

    override val viewModel by viewModel<BViewModel>()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentBBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_b, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxView.clicks(btnNavigateC)
                .subscribeByView { viewModel.navigateC() }

        RxView.clicks(btnNavigateF)
                .subscribeByView { viewModel.navigateF() }

        RxView.clicks(btnSelectItem)
                .subscribeByView { viewModel.selectItem() }
    }
}