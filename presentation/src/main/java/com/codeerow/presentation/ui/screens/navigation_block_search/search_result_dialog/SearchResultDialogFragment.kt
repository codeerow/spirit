package com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListAdapter
import com.codeerow.spirit.navigation.extensions.attachRouter
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.dialog_search_result.*
import org.koin.android.viewmodel.ext.android.viewModel


class SearchResultDialogFragment : DialogFragment() {

    private val viewModel by viewModel<SearchResultViewModel>()


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachRouter(viewModel.router)

        viewModel.setInitialSearchResult(arguments.initialSearchResult)
        setupRecyclerView()

        RxView.clicks(btnMakeSearch)
                .subscribe { viewModel.makeSearch() }

        RxView.clicks(btnNavigateTransactions)
                .subscribe { dismiss() }
    }


    private fun setupRecyclerView() = rvSearchResults.apply {
        viewModel.entities.observe(this@SearchResultDialogFragment, Observer { adapter?.notifyDataSetChanged() })
        layoutManager = LinearLayoutManager(requireContext())
        adapter = StringListAdapter(viewModel)
    }


    /* Bundle extensions */
    var Bundle?.initialSearchResult: String
        set(value) {
            this?.putString(ARG_INITIAL_SEARCH_RESULT, value)
        }
        get() = this?.getString(ARG_INITIAL_SEARCH_RESULT)
                ?: throw IllegalStateException("You should specify initialSearchResult argument.")

    companion object {
        const val ARG_INITIAL_SEARCH_RESULT = "initialSearchResult"
    }
}