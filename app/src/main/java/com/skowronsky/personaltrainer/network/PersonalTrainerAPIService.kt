package com.skowronsky.personaltrainer.network

import com.skowronsky.personaltrainer.network.model.AdvertismentProperty
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://personal-trainer-api.herokuapp.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface PersonalTrainerAPIService {
    @GET("mentee/advertisments")
    suspend fun getAdvertismentProperties(): List<AdvertismentProperty>
}

object PersonalTrainerApi{
    val retrofitService : PersonalTrainerAPIService by lazy {
        retrofit.create(PersonalTrainerAPIService::class.java)
    }
}