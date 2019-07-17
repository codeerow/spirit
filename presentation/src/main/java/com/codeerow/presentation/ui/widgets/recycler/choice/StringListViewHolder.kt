package com.codeerow.presentation.ui.widgets.recycler.choice

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_string.view.*


class StringListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


    fun bind(item: String) {
        view.tvItemValue.text = item
    }
}