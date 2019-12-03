package com.codeerow.presentation.ui.screens.fragment_c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.core.RxFragment
import com.codeerow.spirit.navigation.extensions.attachRouter
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_c.*


class CFragment : RxFragment() {

    private val router = CRouter()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachRouter(router)

        RxView.clicks(btnNavigateD)
                .subscribeByView { router.navigateD() }

        RxView.clicks(btnNavigateE)
                .subscribeByView { router.navigateE() }
    }
}