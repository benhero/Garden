package com.ben.garden

import android.app.Application

class GardenApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        lateinit var app: Application
    }
}
