package com.codeerow.presentation.injection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codeerow.presentation.ui.screens.fragment_a.AViewModel
import com.codeerow.presentation.ui.screens.fragment_b.BViewModel
import com.codeerow.presentation.ui.screens.fragment_c.CViewModel
import com.codeerow.presentation.ui.screens.fragment_d.DViewModel
import com.codeerow.presentation.ui.screens.fragment_e.EViewModel
import com.codeerow.presentation.ui.screens.fragment_f.FViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.transactions.TransactionsViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a.FirstAViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a.SecondAViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_1.FirstBViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2.SecondBViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AViewModel::class)
    internal abstract fun aViewModel(viewModel: AViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BViewModel::class)
    internal abstract fun bViewModel(viewModel: BViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CViewModel::class)
    internal abstract fun cViewModel(viewModel: CViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DViewModel::class)
    internal abstract fun dViewModel(viewModel: DViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EViewModel::class)
    internal abstract fun eViewModel(viewModel: EViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FViewModel::class)
    internal abstract fun fViewModel(viewModel: FViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(SearchResultViewModel::class)
    internal abstract fun searchResultViewModel(viewModel: SearchResultViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TransactionsViewModel::class)
    internal abstract fun transactionsViewModel(viewModel: TransactionsViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FirstAViewModel::class)
    internal abstract fun firstAViewModel(viewModel: FirstAViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondAViewModel::class)
    internal abstract fun secondAViewModel(viewModel: SecondAViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FirstBViewModel::class)
    internal abstract fun firstBViewModel(viewModel: FirstBViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondBViewModel::class)
    internal abstract fun secondBViewModel(viewModel: SecondBViewModel): ViewModel

    // Add view models here
}