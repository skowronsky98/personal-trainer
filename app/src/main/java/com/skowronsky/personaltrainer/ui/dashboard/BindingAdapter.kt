package com.skowronsky.personaltrainer.ui.dashboard

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.domain.Advertisment
import com.skowronsky.personaltrainer.network.dto.AdvertismentDTO

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data : List<Advertisment>?){
    val adapter = recyclerView.adapter as AdvertismentAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
    fun bindStatus(statusImageView: ImageView, status: PersonalTrainerApiStatus?) {
    when (status) {
        PersonalTrainerApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        PersonalTrainerApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        PersonalTrainerApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}


