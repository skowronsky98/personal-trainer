package com.skowronsky.personaltrainer.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.skowronsky.personaltrainer.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

//    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: DashboardViewModel by lazy {
        ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDashboardBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.advertismetRecyclerView.adapter = AdvertismentAdapter()

        return binding.root
    }
}