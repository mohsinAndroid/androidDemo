package com.demo.nytimes.presentation.view

import androidx.recyclerview.widget.DiffUtil
import com.demo.nytimes.domain.model.NyNews

class ItemDiffCallback : DiffUtil.ItemCallback<NyNews>() {

    override fun areItemsTheSame(oldItem: NyNews, newItem: NyNews): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NyNews, newItem: NyNews): Boolean {
        return oldItem == newItem
    }

}