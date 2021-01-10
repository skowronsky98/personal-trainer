package com.skowronsky.personaltrainer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.skowronsky.personaltrainer.database.entity.AdvertismentDao
import com.skowronsky.personaltrainer.database.entity.DatabaseAdvertisment

@Database(entities = [DatabaseAdvertisment::class], version = 1)
abstract class PersonalTrainerDatabase : RoomDatabase() {
    abstract val advertismentDao : AdvertismentDao
}

private lateinit var INSTANCE : PersonalTrainerDatabase

fun getDatabase(context : Context) : PersonalTrainerDatabase{
    synchronized(PersonalTrainerDatabase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                PersonalTrainerDatabase::class.java,
                "personal-trainer").build()
        }
    }
    return INSTANCE
}