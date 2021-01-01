package com.skowronsky.personaltrainer.auth.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.skowronsky.personaltrainer.MainActivity
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
                //TODO Authentication

                navToMainActivity()
                Toast.makeText(context, viewModel.email.value?: "null", Toast.LENGTH_SHORT).show()
                viewModel.eventLoginFinished()
            }
        })

        viewModel.eventNavSignup.observe(viewLifecycleOwner, Observer { navSignup ->
            if(navSignup){
                navToSignup()
                Toast.makeText(context, "Navigation", Toast.LENGTH_SHORT).show()


                viewModel.eventNavSignupFinished()
            }
        })


        return binding.root
    }

    fun navToMainActivity(){
        val intent = Intent(context, MainActivity::class.java)
        activity?.finish()
        startActivity(intent)
    }

    fun navToSignup(){
        val navController = findNavController(this)
        navController.navigate(R.id.action_loginFragment_to_signupFragment)
    }

}