package com.codeerow.spirit.state

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable


fun BehaviorRelay<State>.bindWith(states: Array<BehaviorRelay<State>>) {
    Observable.mergeArray(*states)
            .toFlowable(BackpressureStrategy.LATEST)
            .doOnNext {
                val relationStates = states.map { it.value }
                val obtainedState = State.obtainState(relationStates)
                this.accept(obtainedState)
            }
            .subscribe()
}