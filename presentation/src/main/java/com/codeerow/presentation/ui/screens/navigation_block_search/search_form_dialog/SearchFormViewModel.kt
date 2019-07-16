package com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog

import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.jakewharton.rxrelay2.PublishRelay


open class SearchFormViewModel : MvvmViewModel() {
    val searchForm = PublishRelay.create<String>()
}