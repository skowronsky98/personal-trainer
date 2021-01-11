package com.skowronsky.personaltrainer.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.skowronsky.personaltrainer.database.getDatabase
import com.skowronsky.personaltrainer.repository.PersonalTrainerRepository
import retrofit2.HttpException

class RefreshDataWorker (appContext: Context, params : WorkerParameters): CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val repository = PersonalTrainerRepository(database)
        return try {
            repository.refreshAdvertisments()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}