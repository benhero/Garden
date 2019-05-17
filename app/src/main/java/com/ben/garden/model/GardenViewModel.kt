package com.ben.garden.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ben.garden.data.AppDatabase
import com.ben.garden.data.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GardenViewModel(application: Application) : AndroidViewModel(application) {
    val list: LiveData<List<Plant>> = AppDatabase.getInstance(application).getPlantDao().getBoughtPlants()

    fun buyPlant(plant: Plant) {
        if (plant.isBought) {
            return
        }
        plant.isBought = true
        plant.buyTime = System.currentTimeMillis()
        viewModelScope.launch(Dispatchers.IO) {
            AppDatabase.getInstance(getApplication()).getPlantDao().buyPlant(plant)
        }
    }

    fun isHadBought(plant: Plant): Boolean {
        val value = list.value
        return value?.any {
            it.name == plant.name
        } == true
    }
}