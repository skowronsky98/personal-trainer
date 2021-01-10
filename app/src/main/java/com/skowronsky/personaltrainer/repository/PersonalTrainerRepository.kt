package com.skowronsky.personaltrainer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.skowronsky.personaltrainer.database.PersonalTrainerDatabase
import com.skowronsky.personaltrainer.database.entity.asDomainModel
import com.skowronsky.personaltrainer.domain.Advertisment
import com.skowronsky.personaltrainer.network.PersonalTrainerApi
import com.skowronsky.personaltrainer.network.dto.NetworkAdvertismentContainer
import com.skowronsky.personaltrainer.network.dto.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PersonalTrainerRepository(private val database : PersonalTrainerDatabase)  {
    val advertisments: LiveData<List<Advertisment>> =
            Transformations.map(database.advertismentDao.getAdvertisments()){
                it.asDomainModel()
            }

    suspend fun refreshAdvertisments() {
        withContext(Dispatchers.IO){
            val adv = PersonalTrainerApi.retrofitService.getAdvertismentProperties()

            database.advertismentDao.insertAll(*NetworkAdvertismentContainer(adv).asDatabaseModel())
        }
    }
}