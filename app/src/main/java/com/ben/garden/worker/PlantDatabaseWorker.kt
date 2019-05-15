package com.ben.garden.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ben.garden.data.AppDatabase
import com.ben.garden.data.Plant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class PlantDatabaseWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        return try {
            applicationContext.assets.open("plants.json").use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
                    AppDatabase.getInstance(applicationContext).getPlantDao().insertAll(plantList)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            Result.failure()
        }
    }
}