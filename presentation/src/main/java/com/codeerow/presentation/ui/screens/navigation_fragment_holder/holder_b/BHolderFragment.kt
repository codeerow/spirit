package com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.view.AacNavigationProvider


class BHolderFragment : Fragment(), AacNavigationProvider {

    override var navController = MutableLiveData<NavController>()


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.holder_b_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController.value = (childFragmentManager.findFragmentById(R.id.navFragment) as NavHostFragment).navController
    }
}