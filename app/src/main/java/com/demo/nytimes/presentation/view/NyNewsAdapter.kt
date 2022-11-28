package com.demo.nytimes.presentation.view

import android.view.*
import androidx.recyclerview.widget.*
import com.demo.nytimes.databinding.NewsListItemBinding
import com.demo.nytimes.domain.model.NyNews

internal class NyNewsAdapter(
    private val onNewsClicked: (news: NyNews) -> Unit
) : ListAdapter<NyNews, NyNewsAdapter.ViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onNewsClicked
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(
        private val binding: NewsListItemBinding,
        private val onNewsClicked: (news: NyNews) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NyNews) {
            binding.projectName.text = news.title
            binding.projectDescription.text = news.abstract
            binding.projectItemCardView.setOnClickListener { onNewsClicked(news) }
        }
    }
}