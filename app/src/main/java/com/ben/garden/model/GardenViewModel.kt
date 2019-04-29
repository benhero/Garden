package com.ben.garden.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ben.garden.data.Plant

class GardenViewModel : ViewModel() {
    private val list = MutableLiveData<MutableList<Plant>>()
    init {
        list.value = mutableListOf()
    }

    fun buyPlant(plant: Plant) {
        val value = list.value
        value?.add(plant)
    }

    fun getPlantList(): List<Plant> {
        return list.value!!.toList()
    }

}
