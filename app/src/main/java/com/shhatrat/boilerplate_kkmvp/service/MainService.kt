package com.shhatrat.boilerplate_kkmvp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import org.koin.android.ext.android.inject

class MainService : Service() {

    private val manager by inject<DataManager>()
    private val repositiory by inject<SettingsRepositiory>()

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }


}
