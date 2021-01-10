package com.skowronsky.personaltrainer.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.model.Meal

class HomeRecyclerViewAdapter(private val dailyMeals: List<Meal>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


//        val titleView : TextView = itemView.trainer_surname
//        val nameView : TextView = itemView.trainer_firstname
//        val recipeView : TextView = itemView.trainer_bio
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = dailyMeals[position]

//        holder.titleView.text = currentItem.title
//        holder.nameView.text = currentItem.name
//        holder.recipeView.text = currentItem.recipe
    }

    override fun getItemCount(): Int = dailyMeals.size
}