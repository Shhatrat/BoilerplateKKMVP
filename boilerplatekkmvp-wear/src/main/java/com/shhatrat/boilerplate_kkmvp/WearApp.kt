package com.shhatrat.boilerplate_kkmvp

import android.app.Application
import com.shhatrat.boilerplate_kkmvp.di.Modules
import com.shhatrat.boilerplate_kkmvp.util.base.Preferences
import org.koin.android.ext.android.startKoin

/**
 * Created by szymon on 31/12/17.
 */
class WearApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, Modules.get())
        Preferences.init(this)
    }
}