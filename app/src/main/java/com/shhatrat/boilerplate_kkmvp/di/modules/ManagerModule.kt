package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManagerImpl
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerFake
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerImpl
import com.shhatrat.boilerplate_kkmvp.di.modules.InjectionType.FAKE
import com.shhatrat.boilerplate_kkmvp.di.modules.InjectionType.REAL
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by szymon on 24/12/17.
 */
val managerModule: Module = applicationContext {
    bean(REAL) { DataManagerImpl() } bind DataManager::class
    bean(FAKE) { DataManagerFake() } bind DataManager::class
    bean { ApiManagerImpl(get()) }  bind ApiManager::class
}

object InjectionType{
    val REAL = "REAL"
    val FAKE = "FAKE"
}