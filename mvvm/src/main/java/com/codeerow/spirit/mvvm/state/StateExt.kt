package com.codeerow.spirit.mvvm.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Observer
import com.codeerow.spirit.mvvm.lifecycle.BindableLiveData
import com.codeerow.spirit.state.State
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable


fun BindableLiveData<State>.bindWith(vararg states: BindableLiveData<State>) {
    states.forEach {
        this.addSource(it, Observer {
            val relationStates = this.subscribers.map { it.key.value }
            val obtainedState = State.obtainState(relationStates)
            this.value = obtainedState
        })
    }
}

fun BindableLiveData<State>.bindWith(vararg states: BehaviorRelay<State>) {
    Observable.mergeArray(*states)
            .toFlowable(BackpressureStrategy.LATEST)
            .doOnNext {
                val relationStates = states.map { it.value }
                val obtainedState = State.obtainState(relationStates)
                this.postValue(obtainedState)
            }
            .subscribe()
}


fun BehaviorRelay<State>.toLiveData(): LiveData<State> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable(BackpressureStrategy.LATEST))
}

