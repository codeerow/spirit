package com.codeerow.presentation.ui.widgets.recycler.choice

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.codeerow.presentation.databinding.ListItemStringBinding


class StringListAdapter(private val viewModel: StringListViewModel) : androidx.recyclerview.widget.RecyclerView.Adapter<StringListViewHolder>() {

    override fun getItemCount() = viewModel.entities.value?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemStringBinding.inflate(inflater, parent, false)
        return StringListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StringListViewHolder, position: Int) {
        val itemData = viewModel.entities.value?.get(position)
        itemData?.let(holder::bind)
        viewModel.listBehavior(holder, position)
    }
}