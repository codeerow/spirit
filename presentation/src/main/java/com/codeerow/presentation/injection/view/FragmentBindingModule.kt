package com.codeerow.presentation.injection.view

import com.codeerow.presentation.injection.PerFragment
import com.codeerow.presentation.ui.dialogs.choose_item.ChooseItemDialog
import com.codeerow.presentation.ui.screens.fragment_a.AFragment
import com.codeerow.presentation.ui.screens.fragment_b.BFragment
import com.codeerow.presentation.ui.screens.fragment_c.CFragment
import com.codeerow.presentation.ui.screens.fragment_d.DFragment
import com.codeerow.presentation.ui.screens.fragment_e.EFragment
import com.codeerow.presentation.ui.screens.fragment_f.FFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.transactions.TransactionsFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.AHolderFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_1a.FirstAFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_a.fragment_2a.SecondAFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.BHolderFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_1.FirstBFragment
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2.SecondBFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun aFragment(): AFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bFragment(): BFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun cFragment(): CFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun dFragment(): DFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun eFragment(): EFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun fFragment(): FFragment


    @PerFragment
    @ContributesAndroidInjector
    abstract fun chooseItemDialog(): ChooseItemDialog

    @PerFragment
    @ContributesAndroidInjector
    abstract fun searchFormDialogFragment(): SearchFormDialogFragment


    @PerFragment
    @ContributesAndroidInjector
    abstract fun searchResultDialogFragment(): SearchResultDialogFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun transactionsFragment(): TransactionsFragment


    @PerFragment
    @ContributesAndroidInjector
    abstract fun firstAFragment(): FirstAFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun secondAFragment(): SecondAFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun aHolderFragment(): AHolderFragment


    @PerFragment
    @ContributesAndroidInjector
    abstract fun firstBFragment(): FirstBFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun secondBFragment(): SecondBFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bHolderFragment(): BHolderFragment


    /* Add fragments' modules here */
}