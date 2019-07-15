package com.codeerow.presentation.ui.screens.navigation_block_search.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.base.BaseMvvmFragment
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_transactions.*


class TransactionsFragment : BaseMvvmFragment() {

    override val viewModel by lazy { provideViewModel<TransactionsViewModel>() }


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxView.clicks(btnSearch)
                .subscribeByView { viewModel.makeSearch() }
    }
}