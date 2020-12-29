package com.skowronsky.personaltrainer.auth.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.skowronsky.personaltrainer.R
import com.skowronsky.personaltrainer.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_login, container,false
        )


        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventLogin.observe(viewLifecycleOwner, Observer { login ->
            if (login){
                Toast.makeText(context, viewModel.login.value?: "null", Toast.LENGTH_SHORT).show()
                viewModel.eventLoginFinished()
            }
        })

        return binding.root
    }



}