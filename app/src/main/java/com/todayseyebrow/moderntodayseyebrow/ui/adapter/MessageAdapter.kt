package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.todayseyebrow.moderntodayseyebrow.data.model.Message
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemMessageBinding

class MessageAdapter : ListAdapter<Message, MessageViewHolder>(MessageDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            RvItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = currentList[position]
        holder.bind(message)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(message) }
        }
    }

    private var onItemClickListener: ((Message) -> Unit)? = null
    fun setOnItemClickListener(listener: (Message) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val MessageDiffCallback = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem.messageId == newItem.messageId
            }

            override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem == newItem
            }

        }
    }
}