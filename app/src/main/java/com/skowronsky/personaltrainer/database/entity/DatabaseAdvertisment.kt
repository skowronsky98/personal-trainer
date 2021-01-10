package com.skowronsky.personaltrainer.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.skowronsky.personaltrainer.domain.Advertisment

@Entity(tableName = "advertisment")
data class DatabaseAdvertisment(
        @PrimaryKey
        val id: String,
        val firstname: String,
        val surname: String,
        val age: Int,
        val bio: String,
        val active: Boolean,
        val price: Double,
        val description: String)

fun List<DatabaseAdvertisment>.asDomainModel(): List<Advertisment> {
        return map {
                Advertisment(
                        firstname = it.firstname,
                        surname = it.surname,
                        age = it.age,
                        bio = it.bio,
                        price = it.price,
                        description = it.description
                )
        }
}