package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerFake
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * Created by szymon on 24/12/17.
 */
val managerModule: Module = module{
    factory(TYPE.REAL) { DataManagerImpl() } bind DataManager::class
    factory(TYPE.FAKE) { DataManagerFake() } bind DataManager::class
    }

     object TYPE{
        val REAL = "REAL"
        val FAKE = "FAKE"
    }
