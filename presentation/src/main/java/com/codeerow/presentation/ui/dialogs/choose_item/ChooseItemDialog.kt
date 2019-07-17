package com.codeerow.presentation.ui.dialogs.choose_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListAdapter
import com.codeerow.spirit.mvvm.view.MvvmDialogFragment
import com.codeerow.spirit.mvvm.viewmodel.MvvmViewModel
import kotlinx.android.synthetic.main.dialog_choose_item.*


class ChooseItemDialog : MvvmDialogFragment() {

    private val presentation by lazy { takeViewModel<ChooseItemViewPresentation>() }
    override val viewModel: MvvmViewModel? = null


    /* Lifecycle */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_choose_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() = rvChoices.apply {
        layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
        adapter = StringListAdapter(presentation)

        presentation.listBehavior = { holder, position ->
            holder.itemView.setOnClickListener {
                presentation.entities.value?.get(position)?.let {
                    presentation.selectedItem.value = it
                    this@ChooseItemDialog.dismiss()
                }
            }
        }
    }
}