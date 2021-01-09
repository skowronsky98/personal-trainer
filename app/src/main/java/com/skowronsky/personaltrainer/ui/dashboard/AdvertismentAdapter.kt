package com.skowronsky.personaltrainer.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skowronsky.personaltrainer.databinding.ItemAdvertismentBinding
import com.skowronsky.personaltrainer.network.model.AdvertismentProperty

class AdvertismentAdapter : ListAdapter<AdvertismentProperty, AdvertismentAdapter.AdvertismentPropertyViewHolder>(DiffCallback) {

    class AdvertismentPropertyViewHolder (private val binding : ItemAdvertismentBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(advertismentProperty: AdvertismentProperty){
            binding.property = advertismentProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<AdvertismentProperty>() {
        override fun areItemsTheSame(oldItem: AdvertismentProperty, newItem: AdvertismentProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: AdvertismentProperty, newItem: AdvertismentProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AdvertismentPropertyViewHolder {
        return AdvertismentPropertyViewHolder(ItemAdvertismentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: AdvertismentPropertyViewHolder, position: Int) {
        val advertismentProperty = getItem(position)
        // TODO (09) Call the onClick Function from the onClickListener in a lambda from setOnClickListener
        holder.bind(advertismentProperty)
    }
}