package com.codeerow.presentation.ui.screens.fragment_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.core.RxFragment
import com.codeerow.spirit.navigation.extensions.attachRouter
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_b.*
import org.koin.android.viewmodel.ext.android.viewModel


class BFragment : RxFragment() {

    private val viewModel by viewModel<BViewModel>()

    private val router = BRouter()


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachRouter(router)

        RxView.clicks(btnNavigateC)
                .subscribeByView { router.navigateC() }

        RxView.clicks(btnNavigateF)
                .subscribeByView { router.navigateF() }

        RxView.clicks(btnSelectItem)
                .subscribeByView { router.navigateItem() }

        configureSelectedItem()
    }


    /** configurations */
    private fun configureSelectedItem() {
        viewModel.selectedItem.observe(this, Observer {
            tvSelectedItem.text = it
        })
    }
}