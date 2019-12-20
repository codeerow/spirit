package com.codeerow.presentation.injection

import com.codeerow.presentation.ui.screens.fragment_a.AViewModel
import com.codeerow.presentation.ui.screens.fragment_b.BViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.transactions.TransactionsViewModel
import com.codeerow.presentation.ui.screens.navigation_fragment_holder.holder_b.fragment_2.SecondBViewModel
import com.codeerow.spirit.core.ExceptionDispatcher
import com.codeerow.spirit.mvvm.viewmodel.decoration.SubscriptionDecoration
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModels = module {
    viewModel { AViewModel(get()) }
    viewModel { BViewModel(get()) }
    viewModel { SearchResultViewModel(get()) }
    viewModel { TransactionsViewModel(get()) }
    viewModel { SecondBViewModel(get()) }
}

val errorHandling = module {
    single { ExceptionDispatcher() }
}

val decoration = module {
    single<SubscriptionDecoration> {
        val dispatcher = get<ExceptionDispatcher>()

        object : SubscriptionDecoration {

            override fun <T> Maybe<T>.subscribeDecorated(onSuccess: (T) -> Unit): Disposable {
                return this.subscribeOn(Schedulers.io())
                        .subscribe(onSuccess, { dispatcher.dispatch(it) })
            }

            override fun <T> Single<T>.subscribeDecorated(onSuccess: (T) -> Unit): Disposable {
                return this.subscribeOn(Schedulers.io())
                        .subscribe(onSuccess, { dispatcher.dispatch(it) })
            }

            override fun Completable.subscribeDecorated(onComplete: () -> Unit): Disposable {
                return this.subscribeOn(Schedulers.io())
                        .subscribe(onComplete, { dispatcher.dispatch(it) })
            }

            override fun <T> Observable<T>.subscribeDecorated(onNext: (T) -> Unit): Disposable {
                return this.subscribeOn(Schedulers.io())
                        .subscribe(onNext, { dispatcher.dispatch(it) })
            }

        }
    }
}
