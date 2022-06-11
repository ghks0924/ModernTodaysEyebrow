package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemMemoBinding

class MemoViewHolder(
    private val binding: RvItemMemoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(memo: Memo) {
        val date = memo.memoDate
        val title = if (memo.memoTitle.isNotEmpty()) memo.memoTitle else ""
        val content = if (memo.memoContent.isNotEmpty()) memo.memoContent else ""

        itemView.apply {
            binding.memoTitle.text = title
            binding.memoContent.text = content
            binding.memoTitle.text = date

        }

    }
}