package com.shhatrat.boilerplate_kkmvp

import android.app.Application
import com.shhatrat.boilerplate_kkmvp.di.Modules
import com.shhatrat.boilerplate_kkmvp.util.base.Preferences
import org.koin.android.ext.android.startKoin


/**
 * Created by szymon on 23/12/17.
 */
class Boilerplate: Application(){

    companion object {
        val injectKey = "injectKey"
        val normal = "normal"
        val fav= "fav"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, Modules.get())
        Preferences.init(this)
    }
}