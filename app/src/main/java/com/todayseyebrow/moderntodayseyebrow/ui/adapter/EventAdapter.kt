package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.todayseyebrow.moderntodayseyebrow.data.model.Event
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemEventBinding

class EventAdapter : ListAdapter<Event, EventViewHolder>(EventDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            RvItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = currentList[position]
        holder.bind(event)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(event) }
        }
    }

    private var onItemClickListener: ((Event) -> Unit)? = null
    fun setOnItemClickListener(listener: (Event) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val EventDiffCallback = object : DiffUtil.ItemCallback<Event>() {
            override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem.eventId == newItem.eventId
            }

            override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem == newItem
            }

        }
    }
}