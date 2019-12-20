package com.codeerow.presentation.ui.screens.navigation_block_search.transactions

import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormViewPresentation
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel
import com.codeerow.spirit.mvvm.viewmodel.decoration.SubscriptionDecoration
import com.jakewharton.rxrelay2.PublishRelay


class TransactionsViewModel(subscriptionDecoration: SubscriptionDecoration) : RxViewModel(subscriptionDecoration),
        SearchFormViewPresentation {

    val router = TransactionsRouter()

    override val searchForm: PublishRelay<String> = PublishRelay.create()

    init {
        searchForm.doOnNext(router::navigateSearchResults).subscribeByViewModel()
    }


    fun makeSearch() = router.navigateSearchForm()
}