package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManagerImpl
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerFake
import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManagerImpl
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 24/12/17.
 */
class ManagerModule: AndroidModule(){
    override fun context() = applicationContext {
            provide(REAL) { DataManagerImpl() } bind DataManager::class
            provide(FAKE) { DataManagerFake() } bind DataManager::class

            provide { ApiManagerImpl(get()) } bind ApiManager::class
    }

    companion object {
        val REAL = "REAL"
        val FAKE = "FAKE"
    }
}