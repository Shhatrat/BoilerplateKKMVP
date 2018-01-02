package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.service.MainService
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 1/01/18.
 */
class ServiceModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { MainService() }
    }
}