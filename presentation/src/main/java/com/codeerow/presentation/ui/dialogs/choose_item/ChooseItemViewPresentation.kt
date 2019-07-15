package com.codeerow.presentation.ui.dialogs.choose_item

import androidx.lifecycle.MutableLiveData
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewModel


interface ChooseItemViewPresentation : StringListViewModel {

    val selectedItem: MutableLiveData<String>
}