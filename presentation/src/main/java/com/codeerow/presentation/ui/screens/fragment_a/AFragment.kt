package com.codeerow.presentation.ui.screens.fragment_a

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.core.RxFragment
import com.codeerow.spirit.core.ExceptionDispatcher
import com.codeerow.spirit.core.command.exception.ExceptionHandler
import com.codeerow.spirit.mvvm.state.toLiveData
import com.codeerow.spirit.navigation.extensions.attachRouter
import com.codeerow.spirit.state.State
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_a.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class AFragment : RxFragment(), ExceptionHandler {

    private val viewModel by viewModel<AViewModel>()
    private val exceptionDispatcher by inject<ExceptionDispatcher>()


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exceptionDispatcher.attachHandler(this)
        attachRouter(viewModel.router)

        RxView.clicks(btnNavigateB)
                .subscribeByView { viewModel.router.navigateB() }

        RxView.clicks(btnTransactions)
                .subscribeByView { viewModel.router.navigateTransactions() }

        RxView.clicks(btnMakeRequest)
                .subscribeByView { viewModel.makeRequest() }

        viewModel.apply {
            subscribeForState(
                    state to textViewState,
                    useCase1.state.toLiveData() to textUseCaseState1,
                    useCase2.state.toLiveData() to textUseCaseState2,
                    useCase3.state.toLiveData() to textUseCaseState3)
        }
    }

    private fun subscribeForState(vararg statesAndViews: Pair<LiveData<State>, TextView>) {
        statesAndViews.forEach { stateAndView ->
            stateAndView.first.observe(this, Observer { updateStateText(stateAndView.second, it) })
        }
    }

    private fun updateStateText(view: TextView, state: State?) {
        when (state) {
            is State.Processing -> view.text = "Processing"
            is State.Failure -> view.text = "Failure"
            is State.Success -> view.text = "Success"
            is State.New -> view.text = "New"
            else -> view.text = "Undefined"
        }
    }

    override fun handle(throwable: Throwable): Boolean {
        Log.e("ERROR HANDLING FRAGMENT", "$throwable")
        return super.handle(throwable)
    }
}
