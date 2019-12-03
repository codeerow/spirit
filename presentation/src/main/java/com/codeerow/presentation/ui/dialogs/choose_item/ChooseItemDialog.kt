package com.codeerow.presentation.ui.dialogs.choose_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.codeerow.presentation.R
import com.codeerow.presentation.ui.widgets.recycler.choice.StringListAdapter
import com.codeerow.spirit.mvvm.view.extensions.takeViewModel
import kotlinx.android.synthetic.main.dialog_choose_item.*


class ChooseItemDialog : DialogFragment() {

    private val presentation by lazy { takeViewModel<ChooseItemViewPresentation>() }


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