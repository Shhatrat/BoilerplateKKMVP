package com.shhatrat.boilerplate_kkmvp

import android.app.Application
import com.shhatrat.boilerplate_kkmvp.di.Modules
import com.shhatrat.boilerplate_kkmvp.util.base.ContextProvider
import org.koin.android.ext.android.startKoin


/**
 * Created by szymon on 23/12/17.
 */
class Boilerplate: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, Modules.get())
        ContextProvider.init(this)
    }
}