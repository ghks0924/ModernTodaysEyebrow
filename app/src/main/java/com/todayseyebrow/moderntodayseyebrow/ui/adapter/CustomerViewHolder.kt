package com.todayseyebrow.moderntodayseyebrow.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.todayseyebrow.moderntodayseyebrow.data.model.Customer
import com.todayseyebrow.moderntodayseyebrow.databinding.RvItemCustomerBinding

class CustomerViewHolder(
    private val binding: RvItemCustomerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(customer: Customer) {
        val name = customer.customerName

        itemView.apply {

        }
    }


}