package com.skowronsky.personaltrainer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.databinding.FragmentHomeBinding
import com.skowronsky.personaltrainer.model.Meal

class HomeFragment() : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homeViewModel = viewModel


        val meals = listOf(
            Meal("Essa","Byku","XDDDDDD"),
            Meal("Chuj","sdfg","XDDDDDD"),
            Meal("sadf","Bsdfgyku","sdfg"),
            Meal("sfdgsfd","Byku","sfdg"),
            Meal("sfdgsfd","Byku","sfdg"),
            Meal("sfdgsfd","Byku","sfdg"),
            Meal("sfdgsfd","Byku","sfdg"),
            Meal("sfdgsfd","Byku","sfdg"),
            Meal("Essdfgfsdgsa","Byku","XDDDDDD")
        )

        viewManager = LinearLayoutManager(context)
        viewAdapter = HomeRecyclerViewAdapter(meals)

        recyclerView = binding.mealsRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }

}