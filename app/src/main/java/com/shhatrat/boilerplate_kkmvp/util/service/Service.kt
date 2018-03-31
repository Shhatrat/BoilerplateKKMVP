package com.shhatrat.boilerplate_kkmvp.util.service

import android.app.ActivityManager
import android.app.Service
import android.content.Context


/**
 * Created by szymon on 1/01/18.
 */
inline fun <reified T : Service> Context.isRunning(): Boolean {
    val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
        if (T::class.java.name == service.service.className) {
            return true
        }
    }
    return false
}

