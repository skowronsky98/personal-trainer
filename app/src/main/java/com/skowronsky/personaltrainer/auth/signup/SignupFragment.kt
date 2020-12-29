package com.skowronsky.personaltrainer.auth.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    private lateinit var viewModel: SignupViewModel
    private lateinit var binding: FragmentSignupBinding

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_signup, container,false
        )

        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)

        binding.signupViewModel = viewModel

        return binding.root
    }


}