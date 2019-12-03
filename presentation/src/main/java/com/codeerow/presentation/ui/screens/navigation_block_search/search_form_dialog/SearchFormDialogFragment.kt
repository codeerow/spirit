package com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.codeerow.presentation.R
import com.codeerow.spirit.mvvm.view.extensions.takeViewModel
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.dialog_search_form.*


class SearchFormDialogFragment : DialogFragment() {

    private val presentation by lazy { takeViewModel<SearchFormViewPresentation>() }


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_search_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxView.clicks(btnSearch)
                .subscribe {
                    presentation.searchForm.accept("Search was done")
                    dismiss()
                }
    }
}