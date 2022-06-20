package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.todayseyebrow.moderntodayseyebrow.data.model.Category
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemCategoryBinding

class CategoryViewHolder(
    private val binding: RvItemCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category) {
//        val date = memo.memoDate
//        val title = if (memo.memoTitle.isNotEmpty()) memo.memoTitle else ""
//        val content = if (memo.memoContent.isNotEmpty()) memo.memoContent else ""

        itemView.apply {
//            binding.memoTitle.text = title
//            binding.memoContent.text = content
//            binding.memoTitle.text = date

        }

    }
}