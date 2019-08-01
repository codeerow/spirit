package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.view.AacNavigationFragment
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel


class AHolderFragment : AacNavigationFragment() {

    override var navController = MutableLiveData<NavController>()

    override val viewModel: MvvmViewModel? = null


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.holder_a_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController.value = (childFragmentManager.findFragmentById(R.id.navFragment) as NavHostFragment).navController
    }
}