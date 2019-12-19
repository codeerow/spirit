package com.codeerow.presentation.ui.screens.fragment_a

import com.codeerow.presentation.data.usecases.RandomizedUseCase
import com.codeerow.spirit.core.Executor
import com.codeerow.spirit.mvvm.lifecycle.BindableLiveData
import com.codeerow.spirit.mvvm.state.bindWith
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel
import com.codeerow.spirit.state.State
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import kotlin.random.Random


class AViewModel(private val executor: Executor<Single<*>, Disposable>) : RxViewModel() {

    val state = BindableLiveData<State>(default = State.New())

    val router = ARouter()

    val useCase1 = RandomizedUseCase()
    val useCase2 = RandomizedUseCase()
    val useCase3 = RandomizedUseCase()

    init {
        state.bindWith(useCase1.state, useCase2.state, useCase3.state)
    }

    fun makeRequest() {
        executor.execute(useCase1.start(Random.nextBoolean())).bindToLifecycle()
        executor.execute(useCase2.start(Random.nextBoolean())).bindToLifecycle()
        executor.execute(useCase3.start(Random.nextBoolean())).bindToLifecycle()
    }
}
