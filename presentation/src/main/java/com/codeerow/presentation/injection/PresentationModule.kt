package com.codeerow.presentation.injection

import com.codeerow.presentation.ui.MainActivity
import com.codeerow.presentation.ui.dialogs.choose_item.ChooseItemDialog
import com.codeerow.presentation.ui.screens.fragment_a.AFragment
import com.codeerow.presentation.ui.screens.fragment_a.AViewModel
import com.codeerow.presentation.ui.screens.fragment_b.BFragment
import com.codeerow.presentation.ui.screens.fragment_b.BViewModel
import com.codeerow.presentation.ui.screens.fragment_c.CFragment
import com.codeerow.presentation.ui.screens.fragment_c.CViewModel
import com.codeerow.presentation.ui.screens.fragment_d.DFragment
import com.codeerow.presentation.ui.screens.fragment_e.EFragment
import com.codeerow.presentation.ui.screens.fragment_e.EViewModel
import com.codeerow.presentation.ui.screens.fragment_f.FFragment
import com.codeerow.presentation.ui.screens.fragment_f.FViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.transactions.TransactionsFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.transactions.TransactionsViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.AHolderFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a.FirstAFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a.FirstAViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a.SecondAFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a.SecondAViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.BHolderFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_1.FirstBFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_1.FirstBViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2.SecondBFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2.SecondBViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModels = module {
    viewModel { AViewModel() }
    viewModel { BViewModel() }
    viewModel { CViewModel() }
    viewModel { EViewModel() }
    viewModel { FViewModel() }
    viewModel { SearchResultViewModel() }
    viewModel { TransactionsViewModel() }
    viewModel { FirstAViewModel() }
    viewModel { SecondAViewModel() }
    viewModel { FirstBViewModel() }
    viewModel { SecondBViewModel() }
}


val screens = module {
    factory { MainActivity() }
    factory { AFragment() }
    factory { BFragment() }
    factory { CFragment() }
    factory { DFragment() }
    factory { EFragment() }
    factory { FFragment() }
    factory { ChooseItemDialog() }
    factory { SearchFormDialogFragment() }
    factory { SearchResultDialogFragment() }
    factory { TransactionsFragment() }
    factory { FirstAFragment() }
    factory { SecondAFragment() }
    factory { AHolderFragment() }
    factory { FirstBFragment() }
    factory { SecondBFragment() }
    factory { BHolderFragment() }
}