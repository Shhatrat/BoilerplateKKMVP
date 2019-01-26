package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManagerImpl
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerFake
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * Created by szymon on 24/12/17.
 */
val managerModule: Module = module {
    single(InjectionType.REAL) { DataManagerImpl() } bind DataManager::class
    single(InjectionType.FAKE) { DataManagerFake() } bind DataManager::class
    single { ApiManagerImpl(get()) }  bind ApiManager::class
}

object InjectionType{
    val REAL = "REAL"
    val FAKE = "FAKE"
}