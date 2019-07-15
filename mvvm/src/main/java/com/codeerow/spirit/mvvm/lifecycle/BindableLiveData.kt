package com.codeerow.spirit.mvvm.lifecycle

import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.*


class BindableLiveData<T>(private val default: T? = null) : MutableLiveData<T>() {
    val subscribers = WeakHashMap<LiveData<T>, Source<T>>()

    init {
        this.value = default
    }


    @MainThread
    fun addSource(source: LiveData<T>, onChanged: Observer<T>) {
        val e = Source(source, onChanged)
        val existing = subscribers.putIfAbsent(source, e)
        if (existing != null && existing.mObserver !== onChanged) {
            throw IllegalArgumentException(
                    "This source was already added with the different observer")
        }
        if (existing != null) {
            return
        }
        if (hasActiveObservers()) {
            e.plug()
        }
    }


    @MainThread
    fun removeSource(toRemote: LiveData<T>) {
        val source = subscribers.remove(toRemote)
        source?.unplug()
    }

    @CallSuper
    override fun onActive() {
        for ((_, value) in subscribers) {
            value.plug()
        }
    }

    @CallSuper
    override fun onInactive() {
        for ((_, value) in subscribers) {
            value.unplug()
        }
    }

    class Source<V> internal constructor(internal val mLiveData: LiveData<V>, internal val mObserver: Observer<V>) : Observer<V> {

        internal fun plug() {
            mLiveData.observeForever(this)
        }

        internal fun unplug() {
            mLiveData.removeObserver(this)
        }

        override fun onChanged(v: V?) {
            mObserver.onChanged(v)
        }
    }
}