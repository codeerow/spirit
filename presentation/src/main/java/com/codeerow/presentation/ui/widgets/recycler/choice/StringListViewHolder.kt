package com.codeerow.presentation.ui.widgets.recycler.choice

import androidx.recyclerview.widget.RecyclerView
import com.codeerow.presentation.databinding.ListItemStringBinding


class StringListViewHolder(val binding: ListItemStringBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {


    fun bind(item: String) {
        binding.item = item
        binding.executePendingBindings()
    }
}