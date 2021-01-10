package com.skowronsky.personaltrainer.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skowronsky.personaltrainer.databinding.ItemAdvertismentBinding
import com.skowronsky.personaltrainer.domain.Advertisment

class AdvertismentAdapter : ListAdapter<Advertisment, AdvertismentAdapter.AdvertismentPropertyViewHolder>(DiffCallback) {

    class AdvertismentPropertyViewHolder (private val binding : ItemAdvertismentBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(advertisment: Advertisment){
            binding.property = advertisment
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Advertisment>() {
        override fun areItemsTheSame(oldItem: Advertisment, newItem: Advertisment): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Advertisment, newItem: Advertisment): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AdvertismentPropertyViewHolder {
        return AdvertismentPropertyViewHolder(ItemAdvertismentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AdvertismentPropertyViewHolder, position: Int) {
        val advertismentProperty = getItem(position)

        holder.bind(advertismentProperty)
    }
}