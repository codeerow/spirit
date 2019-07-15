package com.codeerow.presentation.ui.widgets.recycler.choice

import androidx.lifecycle.MutableLiveData


interface StringListViewModel {
    var listBehavior: (item: StringListViewHolder, position: Int) -> Any
    var entities: MutableLiveData<MutableList<String>>
}