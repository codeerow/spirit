package com.codeerow.presentation.data.usecases

import com.codeerow.spirit.domain.usecase.UseCase
import com.codeerow.spirit.state.State
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import kotlin.random.Random


class RandomizedUseCase : UseCase() {

    val state = BehaviorRelay.createDefault<State>(State.New())


    fun start(success: Boolean): Single<Int> {
        state.accept(State.New())
        return Single.just(Random.nextInt(0, 10))
                .doOnSubscribe { state.accept(State.Processing()) }
                .delay(2, TimeUnit.SECONDS)
                .delaySubscription(Random.nextLong(0, 3), TimeUnit.SECONDS)
                .doOnSuccess {
                    if (success) state.accept(State.Success())
                    if (!success) state.accept(State.Failure(mutableListOf(Throwable())))
                }
    }
}