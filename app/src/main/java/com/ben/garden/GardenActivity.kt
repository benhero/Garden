package com.ben.garden

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class GardenActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garden_activity)

        // 获取导航控制器
        navController = Navigation.findNavController(this, R.id.garden_nav_fragment)
        // 关联导航控制器的导航图与其他组件
        appBarConfiguration = AppBarConfiguration(navController.graph, null)
        // 设置Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        // 关联导航控制器与配置好的参数
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        // 处理导航器的点击
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
