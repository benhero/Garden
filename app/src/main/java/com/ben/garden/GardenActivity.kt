package com.ben.garden

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GardenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garden_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, GardenFragment.newInstance())
//                .commitNow()
//        }
    }

}
