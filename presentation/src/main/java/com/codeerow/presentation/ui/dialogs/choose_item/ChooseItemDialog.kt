package com.codeerow.presentation.ui.dialogs.choose_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.screens.fragment_b.BViewModel
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListAdapter
import com.codeerow.spirit.mvvm.view.MvvmDialogFragment
import kotlinx.android.synthetic.main.dialog_choose_item.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class ChooseItemDialog : MvvmDialogFragment() {

    override val viewModel by sharedViewModel<BViewModel>()


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
        adapter = StringListAdapter(viewModel)

        viewModel.listBehavior = { holder, position ->
            holder.itemView.setOnClickListener {
                viewModel.entities.value?.get(position)?.let {
                    viewModel.selectedItem.value = it
                    this@ChooseItemDialog.dismiss()
                }
            }
        }
    }
}