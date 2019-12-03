package com.codeerow.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.view.AacNavigationProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AacNavigationProvider {

    override var navController = MutableLiveData<NavController>()

    /* Toolbar */
    private val toolbar: Toolbar by lazy { main_toolbar }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }


    /* Lifecycle */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        navController.value = (navFragment as NavHostFragment).navController
    }
}
