package com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog

import androidx.fragment.app.DialogFragment
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormDialogFragment
import com.codeerow.spirit.navigation.Router
import com.codeerow.spirit.navigation.command.ShowDialog


class SearchResultRouter : Router() {

    fun navigateSearchForm() {
        navigationBus.value = ShowDialog(SearchFormDialogFragment().apply { setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen) })
    }
}