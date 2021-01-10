package com.skowronsky.personaltrainer.ui.dashboard

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.skowronsky.personaltrainer.database.entity.DatabaseAdvertisment
import com.skowronsky.personaltrainer.database.getDatabase
import com.skowronsky.personaltrainer.domain.Advertisment
import com.skowronsky.personaltrainer.network.PersonalTrainerApi
import com.skowronsky.personaltrainer.network.dto.AdvertismentDTO
import com.skowronsky.personaltrainer.network.dto.NetworkAdvertismentContainer
import com.skowronsky.personaltrainer.network.dto.asDomainModel
import com.skowronsky.personaltrainer.repository.PersonalTrainerRepository
import kotlinx.coroutines.launch
import java.lang.reflect.Array

enum class PersonalTrainerApiStatus { LOADING, ERROR, DONE }


class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<PersonalTrainerApiStatus>()
    val status: LiveData<PersonalTrainerApiStatus>
        get() = _status


    private val database = getDatabase(application)
    private val personalTrainerRepository = PersonalTrainerRepository(database)

    val properties = personalTrainerRepository.advertisments

    init {
            refreshData()
    }

    private fun refreshData() {
        viewModelScope.launch {
            personalTrainerRepository.refreshAdvertisments()
//            _properties = personalTrainerRepository.advertisments
        }
    }

//    private fun getTrainersAdvertismentProperties(){
//        viewModelScope.launch {
//            _status.value = PersonalTrainerApiStatus.LOADING
//            try {
//                Log.i("retrofit","before")
//                val container = PersonalTrainerApi.retrofitService.getAdvertismentProperties()
//
////                _properties.value = NetworkAdvertismentContainer(container).asDomainModel()
////                Log.i("retrofit", container.advertisments.size.toString())
//                _status.value = PersonalTrainerApiStatus.DONE
//
//            }catch (e:Exception){
//                Log.i("retrofit",e.message.toString())
//                _status.value = PersonalTrainerApiStatus.ERROR
////                _properties.value = ArrayList()
//
//            }
//        }
//    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DashboardViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
