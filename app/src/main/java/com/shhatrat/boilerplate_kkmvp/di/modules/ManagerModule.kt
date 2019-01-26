package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerFake
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerImpl
import com.shhatrat.boilerplate_kkmvp.di.modules.InjectionType.FAKE
import com.shhatrat.boilerplate_kkmvp.di.modules.InjectionType.REAL
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * Created by szymon on 24/12/17.
 */
val managerModule: Module = module {
    single(REAL) { DataManagerImpl() } bind DataManager::class
    single(FAKE) { DataManagerFake() } bind DataManager::class
}

object InjectionType{
    val REAL = "REAL"
    val FAKE = "FAKE"
}