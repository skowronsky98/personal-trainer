package com.skowronsky.personaltrainer.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin :LiveData<Boolean>
        get() = _eventLogin

    private val _eventNavSignup = MutableLiveData<Boolean>()
    val eventNavSignup : LiveData<Boolean>
        get() = _eventNavSignup


    fun eventLoginStart() {
        _eventLogin.value = true
    }

    fun eventLoginFinished(){
        _eventLogin.value = false
    }

    fun eventNavSignupStart(){
        _eventNavSignup.value = true
    }

    fun eventNavSignupFinished(){
        _eventNavSignup.value = false
    }

}