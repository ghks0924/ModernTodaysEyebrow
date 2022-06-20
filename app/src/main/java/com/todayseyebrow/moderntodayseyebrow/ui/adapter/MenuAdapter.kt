package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.todayseyebrow.moderntodayseyebrow.data.model.Menu
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemMenuBinding

class MenuAdapter : ListAdapter<Menu, MenuViewHolder>(MenuDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            RvItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = currentList[position]
        holder.bind(menu)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(menu) }
        }
    }

    private var onItemClickListener: ((Menu) -> Unit)? = null
    fun setOnItemClickListener(listener: (Menu) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val MenuDiffCallback = object : DiffUtil.ItemCallback<Menu>() {
            override fun areItemsTheSame(oldItem: Menu, newItem: Menu): Boolean {
                return oldItem.menuId == newItem.menuId
            }

            override fun areContentsTheSame(oldItem: Menu, newItem: Menu): Boolean {
                return oldItem == newItem
            }

        }
    }
}