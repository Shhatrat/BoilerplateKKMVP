package com.shhatrat.boilerplate_kkmvp.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.InitActivity
import org.koin.android.ext.android.inject


class MainService : Service() {

    companion object {
        val foreground = "foreground"
        val NOTIFICATION_ID = 123
        val CHANNEL_ID = "Simple_channel"
    }

    private val manager by inject<DataManager>()
    private val repositiory by inject<SettingsRepositiory>()

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun checkForeground(intent: Intent?){
        if(intent?.extras?.get(foreground)==true)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                newNotification()
            oldNotification()
        }
    }

    private fun oldNotification(){
        val notificationIntent = Intent(this, InitActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, Intent.FILL_IN_ACTION)
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(getString(R.string.app_name))
                .setContentIntent(pendingIntent).build()
        startForeground(NOTIFICATION_ID , notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun newNotification(){
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = CHANNEL_ID
        val name = "Android wear"
        val description = "This is notification for Android Wear support"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id, name, importance)
        mChannel.description = description
        mChannel.enableLights(true)
        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        mNotificationManager.createNotificationChannel(mChannel)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        checkForeground(intent)
        return super.onStartCommand(intent, flags, startId)
    }

}
