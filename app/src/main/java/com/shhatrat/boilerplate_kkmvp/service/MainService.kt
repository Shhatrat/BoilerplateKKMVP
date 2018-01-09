package com.shhatrat.boilerplate_kkmvp.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.MainActivity
import org.koin.android.ext.android.inject


class MainService : Service() {

    companion object {
        val foreground = "foreground"
        val notificationId = 123
    }

    private val manager by inject<DataManager>()
    private val repositiory by inject<SettingsRepositiory>()

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun checkForeground(intent: Intent?){
        if(intent?.extras?.get(foreground)==true)
        {
            val notificationIntent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0,
                    notificationIntent, Intent.FILL_IN_ACTION)

            val notification = NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText(getString(R.string.app_name))
                    .setContentIntent(pendingIntent).build()

            startForeground(notificationId , notification)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        checkForeground(intent)
        return super.onStartCommand(intent, flags, startId)
    }

}
