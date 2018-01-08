package com.shhatrat.boilerplate_kkmvp.di.modules

import com.patloew.rxwear.RxWear
import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManager
import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManagerImpl
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 27/12/17.
 */
class WearModule: AndroidModule() {
    override fun context() = applicationContext {
        provide { WearManagerImpl(getRxWear()) } bind WearManager::class
    }

    fun getRxWear() = RxWear(context)
}