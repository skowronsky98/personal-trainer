package com.skowronsky.personaltrainer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.databinding.FragmentCollectionHomeBinding

class CollectionHomeFragment : Fragment() {

    private lateinit var binding: FragmentCollectionHomeBinding
    private lateinit var homeCollectionAdapter: HomeCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collection_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeCollectionAdapter = HomeCollectionAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = homeCollectionAdapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position->
            tab.text = weekdays(position)
        }.attach()
    }

    private fun weekdays(value:Int): String = when (value) {
            0 -> "Mon"
            1 -> "Tue"
            2 -> "Wen"
            3 -> "Thu"
            4 -> "Fri"
            5 -> "Sat"
            6 -> "Sun"
            else -> "Wrong value"
    }

}