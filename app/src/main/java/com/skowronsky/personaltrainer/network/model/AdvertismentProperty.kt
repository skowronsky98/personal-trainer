package com.skowronsky.personaltrainer.network.model

import com.squareup.moshi.Json

data class AdvertismentProperty(
    @Json(name = "_id") val id: String,
    val firstname: String,
    val surname: String,
    val age: Int,
    val bio: String,
    val price: Double,
    val description: String
) {

}