package com.codeerow.pandora.box.common.provider

import android.arch.lifecycle.MutableLiveData


interface ViewStateProvider<VS : Any> {
    var viewState: MutableLiveData<ViewState<VS>>


    fun refreshViewState() {
        viewState = MutableLiveData()
    }
}


data class ViewState<CUSTOM_STATES : Any>(var customState: CUSTOM_STATES)