package com.shhatrat.boilerplate_kkmvp.di.modules

import com.patloew.rxwear.RxWear
import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManager
import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManagerImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by szymon on 27/12/17.
 */
val wearModule: Module  = applicationContext {
        bean { WearManagerImpl(RxWear(get())) } bind WearManager::class
}

