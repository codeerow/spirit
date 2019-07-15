package com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog

import com.jakewharton.rxrelay2.PublishRelay


interface SearchFormViewPresentation {

    val searchForm: PublishRelay<String>
}