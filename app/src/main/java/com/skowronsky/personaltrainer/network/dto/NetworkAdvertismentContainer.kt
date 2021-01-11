package com.skowronsky.personaltrainer.network.dto

import com.skowronsky.personaltrainer.database.entity.DatabaseAdvertisment
import com.skowronsky.personaltrainer.domain.Advertisment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAdvertismentContainer(val advertisments: List<AdvertismentDTO>)

@JsonClass(generateAdapter = true)
data class AdvertismentDTO(
    @Json(name = "_id") val id: String,
    val firstname: String,
    val surname: String,
    val age: Int,
    val bio: String,
    val active: Boolean,
    val price: Double,
    val description: String
)

fun NetworkAdvertismentContainer.asDomainModel(): List<Advertisment> {
    return advertisments.map {
        Advertisment(
                firstname = it.firstname,
                surname = it.surname,
                age = it.age,
                bio = it.bio,
                price = it.price,
                description = it.description)
    }
}

fun NetworkAdvertismentContainer.asDatabaseModel(): Array<DatabaseAdvertisment> {
    return advertisments.map {
        DatabaseAdvertisment(
                id = it.id,
                firstname = it.firstname,
                surname = it.surname,
                age = it.age,
                bio = it.bio,
                active = it.active,
                price = it.price,
                description = it.description)
    }.toTypedArray()
}