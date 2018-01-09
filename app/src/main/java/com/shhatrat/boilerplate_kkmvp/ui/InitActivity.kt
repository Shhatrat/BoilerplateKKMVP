package com.shhatrat.boilerplate_kkmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.service.MainService
import com.shhatrat.boilerplate_kkmvp.ui.main.MainActivity
import com.shhatrat.boilerplate_kkmvp.util.service.isRunning
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startService
import org.jetbrains.anko.stopService
import org.koin.android.ext.android.inject


class InitActivity : AppCompatActivity() {

    private val settingsRepositiory by inject<SettingsRepositiory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareService()
        startActivity<MainActivity>()
    }

    private fun prepareService(){
        if(isRunning<MainService>())
            stopService<MainService>()
        if(settingsRepositiory.wear)
            if(settingsRepositiory.backgroundService)
                startService<MainService>(MainService.foreground to true)
            else
                startService<MainService>()
    }
}
