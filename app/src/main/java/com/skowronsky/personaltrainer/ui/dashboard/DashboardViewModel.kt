package com.skowronsky.personaltrainer.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skowronsky.personaltrainer.network.PersonalTrainerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response

    private val _text = MutableLiveData<String>().apply {
        value = "Essa"
    }
    val text: LiveData<String>
        get() = _text

    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getTrainersAdvertismentProperties()
    }

    private fun getTrainersAdvertismentProperties(){
        coroutineScope.launch {
            var getPropertiesDeferred = PersonalTrainerApi.retrofitService.getAdvertismentPropertiesAsync()
            try {
                var listResult = getPropertiesDeferred.await()
                _response.value = "Succes: ${listResult.size}"

            }catch (t:Throwable){
                _response.value = "Failure: " + t

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
