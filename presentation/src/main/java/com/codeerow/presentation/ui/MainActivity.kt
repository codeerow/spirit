package com.codeerow.presentation.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.view.AacNavigationActivity
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AacNavigationActivity() {

    override val viewModel: MvvmViewModel? = null

    override var navController = MutableLiveData<NavController>()

    /* Toolbar */
    private val toolbar: Toolbar by lazy { main_toolbar }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }


    /* Lifecycle */
    override fun inflateLayout() {
        setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
        navController.value = (navFragment as NavHostFragment).navController
    }
}
