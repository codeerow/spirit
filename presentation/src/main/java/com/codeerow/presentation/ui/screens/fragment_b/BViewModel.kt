package com.codeerow.presentation.ui.screens.fragment_b

import androidx.lifecycle.MutableLiveData
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.dialogs.choose_item.ChooseItemDialog
import com.codeerow.presentation.ui.dialogs.choose_item.ChooseItemViewPresentation
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListViewHolder
import com.codeerow.spirit.aac_navigation.command.AacGoForward
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import com.codeerow.spirit.navigation.command.ShowDialog
import com.codeerow.spirit.navigation.extensions.navigate


class BViewModel : MvvmViewModel(),
        ChooseItemViewPresentation {

    override var listBehavior: (item: StringListViewHolder, position: Int) -> Any = { _, _ -> }
    override var entities: MutableLiveData<MutableList<String>> = MutableLiveData()
    override val selectedItem = MutableLiveData<String>()

    init {
        selectedItem.value = "Item wasn't selected."
        entities.value = mutableListOf("Item_1", "Item_2", "Item_3", "Item_4", "Item_5")
    }


    fun selectItem() {
        navigate(ShowDialog(ChooseItemDialog()))
    }


    /* Navigation */
    fun navigateC() {
        navigate(AacGoForward(
                actionID = R.id.action_BFragment_to_CFragment))
    }


    fun navigateF() {
        navigate(AacGoForward(
                actionID = R.id.action_BFragment_to_FFragment))
    }
}