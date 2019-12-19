package com.codeerow.presentation.injection

import com.codeerow.presentation.ui.screens.fragment_a.AViewModel
import com.codeerow.presentation.ui.screens.fragment_b.BViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.transactions.TransactionsViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2.SecondBViewModel
import com.codeerow.spirit.core.ExceptionDispatcher
import com.codeerow.spirit.core.Executor
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModels = module {
    viewModel { AViewModel(get()) }
    viewModel { BViewModel() }
    viewModel { SearchResultViewModel() }
    viewModel { TransactionsViewModel() }
    viewModel { SecondBViewModel() }
}

val errorHandling = module {
    single { ExceptionDispatcher() }
}

val executors = module {
    single<Executor<Single<*>, Disposable>> {
        val dispatcher = get<ExceptionDispatcher>()

        object : Executor<Single<*>, Disposable> {
            override fun execute(input: Single<*>): Disposable {
                return input
                        .subscribeOn(Schedulers.io())
                        .subscribe({}, { dispatcher.dispatch(it) })
            }
        }
    }
}
