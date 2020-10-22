package com.skowronsky.personaltrainer.ui.notifications

import android.database.DatabaseUtils
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
import com.skowronsky.personaltrainer.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var viewModel: NotificationsViewModel
    private lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        viewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false)

        binding.viewModel = viewModel

        return binding.root
    }
}