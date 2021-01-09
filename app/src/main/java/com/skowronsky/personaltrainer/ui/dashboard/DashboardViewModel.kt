package com.skowronsky.personaltrainer.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skowronsky.personaltrainer.network.PersonalTrainerApi
import com.skowronsky.personaltrainer.network.model.AdvertismentProperty
import kotlinx.coroutines.launch
import java.lang.Exception

enum class PersonalTrainerApiStatus { LOADING, ERROR, DONE }


class DashboardViewModel : ViewModel() {

    private val _status = MutableLiveData<PersonalTrainerApiStatus>()
    val status: LiveData<PersonalTrainerApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<AdvertismentProperty>>()
    val properties: LiveData<List<AdvertismentProperty>>
        get() = _properties

    init {
        getTrainersAdvertismentProperties()
    }

    private fun getTrainersAdvertismentProperties(){
        viewModelScope.launch {
            _status.value = PersonalTrainerApiStatus.LOADING
            try {
                Log.i("retrofit","before")
                _properties.value = PersonalTrainerApi.retrofitService.getAdvertismentProperties()
                Log.i("retrofit","after")
                _status.value = PersonalTrainerApiStatus.DONE

            }catch (e:Exception){
//                Log.i("retrofit",_properties.value!!.size.toString())
                _status.value = PersonalTrainerApiStatus.ERROR
                _properties.value = ArrayList()

            }
        }

    }

}
