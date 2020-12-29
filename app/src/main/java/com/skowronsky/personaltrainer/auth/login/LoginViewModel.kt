package com.skowronsky.personaltrainer.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val login = MutableLiveData<String>()

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin :LiveData<Boolean>
        get() = _eventLogin

    fun eventLoginStart() {
        _eventLogin.value = true
    }

    fun eventLoginFinished(){
        _eventLogin.value = false
    }

}