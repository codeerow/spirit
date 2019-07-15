package com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog

import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormViewPresentation
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewHolder
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewModel
import com.codeerow.spirit.R
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.command.ShowDialog
import com.codeerow.spirit.navigation.extensions.navigate
import com.jakewharton.rxrelay2.PublishRelay
import javax.inject.Inject


class SearchResultViewModel @Inject constructor() : MvvmViewModel(),
        StringListViewModel,
        SearchFormViewPresentation {

    /* Search results list setup */
    override var listBehavior: (item: StringListViewHolder, position: Int) -> Any = { _, _ -> }
    override var entities = MutableLiveData<MutableList<String>>()

    override val searchForm: PublishRelay<String> = PublishRelay.create()

    init {
        entities.value = mutableListOf()
        searchForm.doOnNext {
            entities.value?.add(it)
            entities.value = entities.value
        }.subscribeByViewModel()
    }


    fun setInitialSearchResult(searchResult: String) {
        if (entities.value?.size == 0) {
            entities.value?.add(searchResult)
            entities.value = entities.value
        }
    }

    fun makeSearch() {
        navigate(ShowDialog(SearchFormDialogFragment().apply { setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen) }))
    }
}