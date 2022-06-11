package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemMemoBinding

class MemoAdapter : ListAdapter<Memo, MemoViewHolder>(MemoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(
            RvItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val memo = currentList[position]
        holder.bind(memo)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(memo) }
        }
    }

    private var onItemClickListener: ((Memo) -> Unit)? = null
    fun setOnItemClickListener(listener: (Memo) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val MemoDiffCallback = object : DiffUtil.ItemCallback<Memo>() {
            override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                return oldItem.memoId == newItem.memoId
            }

            override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                return oldItem == newItem
            }

        }
    }
}