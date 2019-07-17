package com.codeerow.presentation.ui.widgets.recycler.choice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codeerow.presentation.R


class StringListAdapter(private val viewModel: StringListViewModel) : RecyclerView.Adapter<StringListViewHolder>() {

    override fun getItemCount() = viewModel.entities.value?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_string, parent, false)
        return StringListViewHolder(view)
    }

    override fun onBindViewHolder(holder: StringListViewHolder, position: Int) {
        val itemData = viewModel.entities.value?.get(position)
        itemData?.let(holder::bind)
        viewModel.listBehavior(holder, position)
    }
}