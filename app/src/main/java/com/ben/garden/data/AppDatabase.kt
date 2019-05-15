package com.ben.garden.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.ben.garden.util.DATABASE_NAME
import com.ben.garden.worker.PlantDatabaseWorker


@Database(entities = [Plant::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPlantDao(): PlantDao

    companion object {
        private var appDataBase: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (appDataBase == null) {
                synchronized(AppDatabase::class.java) {
                    if (appDataBase == null) {
                        appDataBase = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    val request = OneTimeWorkRequest.Builder(PlantDatabaseWorker::class.java).build()
                                    WorkManager.getInstance().enqueue(request)
                                }
                            })
                            .build()
                        return appDataBase!!
                    }
                }
            }
            return appDataBase!!
        }
    }
}