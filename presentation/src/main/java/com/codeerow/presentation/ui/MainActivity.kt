package com.codeerow.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeerow.presentation.R
import com.codeerow.spirit.aac_navigation.view.AacNavigationProvider
import com.codeerow.spirit.core.ExceptionDispatcher
import com.codeerow.spirit.core.command.exception.ExceptionHandler
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), AacNavigationProvider, ExceptionHandler {

    override var navController = MutableLiveData<NavController>()
    private val exceptionDispatcher by inject<ExceptionDispatcher>()

    /* Toolbar */
    private val toolbar: Toolbar by lazy { main_toolbar }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }


    /** Lifecycle */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exceptionDispatcher.attachHandler(this)
        setContentView(R.layout.activity_main)
        navController.value = (navFragment as NavHostFragment).navController
        setupToolbar()
    }

    override fun onDestroy() {
        super.onDestroy()
        onBackPressedDispatcher
        exceptionDispatcher.detachHandler(this)
    }


    override fun handle(throwable: Throwable): Boolean {
        Log.e("ERROR HANDLING ACTIVITY", "$throwable")
        return super.handle(throwable)
    }
}
