package com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog

import androidx.lifecycle.MutableLiveData
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormViewPresentation
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewHolder
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewModel
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel
import com.jakewharton.rxrelay2.PublishRelay


class SearchResultViewModel : RxViewModel(),
        StringListViewModel,
        SearchFormViewPresentation {

    val router = SearchResultRouter()

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

    fun makeSearch() = router.navigateSearchForm()
}