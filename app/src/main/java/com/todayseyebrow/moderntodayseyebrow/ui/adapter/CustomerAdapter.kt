package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.todayseyebrow.moderntodayseyebrow.data.model.Customer
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemCustomerBinding

class CustomerAdapter : ListAdapter<Customer, CustomerViewHolder>(CustomerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        return CustomerViewHolder(
            RvItemCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = currentList[position]
        holder.bind(customer)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(customer)
            }
        }
    }

    private var onItemClickListener: ((Customer) -> Unit)? = null

    fun setOnItemClickListener(listener: (Customer) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val CustomerDiffCallback = object : DiffUtil.ItemCallback<Customer>() {
            override fun areItemsTheSame(oldItem: Customer, newItem: Customer): Boolean {
                return oldItem.customerId == newItem.customerId
            }

            override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean {
                return oldItem == newItem
            }

        }
    }
}