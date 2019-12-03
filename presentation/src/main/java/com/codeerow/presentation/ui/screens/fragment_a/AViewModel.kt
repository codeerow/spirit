package com.codeerow.presentation.ui.screens.fragment_a

import com.codeerow.presentation.data.usecases.RandomizedUseCase
import com.codeerow.spirit.mvvm.lifecycle.BindableLiveData
import com.codeerow.spirit.mvvm.state.bindWith
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel
import com.codeerow.spirit.state.State
import io.reactivex.schedulers.Schedulers
import kotlin.random.Random


class AViewModel : RxViewModel() {

    val state = BindableLiveData<State>(default = State.New())

    val router = ARouter()

    val useCase1 = RandomizedUseCase()
    val useCase2 = RandomizedUseCase()
    val useCase3 = RandomizedUseCase()

    init {
        state.bindWith(useCase1.state, useCase2.state, useCase3.state)
    }

    fun makeRequest() {
        useCase1.start(Random.nextBoolean()).subscribeOn(Schedulers.io()).subscribeByViewModel()
        useCase2.start(Random.nextBoolean()).subscribeOn(Schedulers.io()).subscribeByViewModel()
        useCase3.start(Random.nextBoolean()).subscribeOn(Schedulers.io()).subscribeByViewModel()
    }
}