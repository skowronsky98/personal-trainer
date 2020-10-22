package com.skowronsky.personaltrainer.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_dashboard, container,false
        )

        viewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding.dashboardViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}