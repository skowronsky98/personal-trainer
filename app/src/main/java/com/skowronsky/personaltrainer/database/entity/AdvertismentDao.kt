package com.skowronsky.personaltrainer.database.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AdvertismentDao{
    @Query("select * from advertisment")
    fun getAdvertisments(): LiveData<List<DatabaseAdvertisment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg databaseAdvertisment: DatabaseAdvertisment)
    
}