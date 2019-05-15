package com.ben.garden.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ben.garden.data.AppDatabase
import com.ben.garden.data.Plant

class MarketViewModel(application: Application) : AndroidViewModel(application) {

    val list : LiveData<List<Plant>> = AppDatabase.getInstance(application).getPlantDao().getPlants()

    init {
//        val plant = AppDatabase.getInstance(GardenApplication.app).getPlantDao().getPlants().value
//        if (plant != null) {
//            for (p in plant) {
//                Log.i("JKL", "setPlant: $p")
//            }
//        }
//        plant?.let { setPlant(it) }
    }

    fun setPlant(plants: List<Plant>) {
        for (plant in plants) {
            Log.i("JKL", "setPlant: $plant")
        }
//        list.value?.clear()
//        list.value?.addAll(plants)
    }

//    fun getPlantList(): List<Plant> {
//        return list.value!!.toList()
//    }
}
