package com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.base.BaseMvvmDialogFragment
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListAdapter
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.dialog_search_result.*


class SearchResultDialogFragment : BaseMvvmDialogFragment() {
    override val viewModel by lazy { provideViewModel<SearchResultViewModel>() }


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setInitialSearchResult(arguments.initialSearchResult)
        setupRecyclerView()

        RxView.clicks(btnMakeSearch)
                .subscribeByView { viewModel.makeSearch() }

        RxView.clicks(btnNavigateTransactions)
                .subscribeByView { dismiss() }
    }


    private fun setupRecyclerView() = rvSearchResults.apply {
        viewModel.entities.observe(this@SearchResultDialogFragment, Observer { adapter?.notifyDataSetChanged() })
        layoutManager = LinearLayoutManager(requireContext())
        adapter = StringListAdapter(viewModel)
    }


    /* Bundle extensions */
    var Bundle?.initialSearchResult: String
        set(value) { this?.putString(ARG_INITIAL_SEARCH_RESULT, value) }
        get() = this?.getString(ARG_INITIAL_SEARCH_RESULT) ?: throw IllegalStateException("You should specify initialSearchResult argument.")

    companion object {
        const val ARG_INITIAL_SEARCH_RESULT = "initialSearchResult"
    }
}