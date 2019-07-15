package com.codeerow.presentation.ui.screens.fragment_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.base.BaseMvvmFragment
import com.codeerow.spirit.mvvm.state.toLiveData
import com.codeerow.spirit.state.State
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_a.*


class AFragment : BaseMvvmFragment() {

    override val viewModel by lazy { provideViewModel<AViewModel>() }


    /** lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxView.clicks(btnNavigateB)
                .subscribeByView { viewModel.navigateB() }

        RxView.clicks(btnTransactions)
                .subscribeByView { viewModel.navigateTransactions() }

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
}