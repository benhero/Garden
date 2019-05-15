package com.ben.garden.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ben.garden.data.Plant

class GardenViewModel : ViewModel() {
    private val list = MutableLiveData<MutableList<Plant>>()
    init {
        list.value = arrayListOf()
    }

    fun buyPlant(plant: Plant) {
        if (isHadBuy(plant)) {
            return
        }
        list.value?.add(plant)
    }

    fun getPlantList(): List<Plant> {
        return list.value!!.toList()
    }

    fun isHadBuy(plant: Plant): Boolean {
        val value = list.value
        value?.forEach { it ->
            if (it.name == plant.name) {
                return true
            }
        }
        return false
    }

}
