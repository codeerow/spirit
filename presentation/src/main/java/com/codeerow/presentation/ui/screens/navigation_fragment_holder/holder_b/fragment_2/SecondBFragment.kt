package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.dsl_databinding.databinding
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.MvvmFragment
import com.codeerow.spirit.navigation.view.BackPressedDelegate
import kotlinx.android.synthetic.main.fragment_2b.*
import org.koin.android.viewmodel.ext.android.viewModel


class SecondBFragment : MvvmFragment(), BackPressedDelegate {

    override val viewModel by viewModel<SecondBViewModel>()


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_2b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding {
            with(textExitWarning) {
                visibility(viewModel.exitWarningIsShown)
            }
        }
    }


    /** back pressed */
    override fun onBackPressed(): Boolean {
        return if (viewModel.exitWarningIsShown.value == true) false
        else {
            viewModel.exitWarningIsShown.value = true
            true
        }
    }
}