package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.base.BaseMvvmFragment


class SecondBFragment : BaseMvvmFragment() {

    override val viewModel by lazy { provideViewModel<SecondBViewModel>() }


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_2b, container, false)
    }
}