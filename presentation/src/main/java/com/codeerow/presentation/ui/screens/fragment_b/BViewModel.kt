package com.codeerow.presentation.ui.screens.fragment_b

import androidx.lifecycle.MutableLiveData
import com.codeerow.presentation.ui.dialogs.choose_item.ChooseItemViewPresentation
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewHolder
import com.codeerow.spirit.mvvm.viewmodel.RxViewModel


class BViewModel : RxViewModel(),
        ChooseItemViewPresentation {

    override var listBehavior: (item: StringListViewHolder, position: Int) -> Any = { _, _ -> }
    override var entities: MutableLiveData<MutableList<String>> = MutableLiveData()
    override val selectedItem = MutableLiveData<String>()

    init {
        selectedItem.value = "Item wasn't selected."
        entities.value = mutableListOf("Item_1", "Item_2", "Item_3", "Item_4", "Item_5")
    }
}