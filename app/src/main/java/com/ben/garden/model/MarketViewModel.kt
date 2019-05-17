package com.ben.garden.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ben.garden.data.AppDatabase
import com.ben.garden.data.Plant

class MarketViewModel(application: Application) : AndroidViewModel(application) {
    val list: LiveData<List<Plant>> = AppDatabase.getInstance(application).getPlantDao().getPlants()
}
