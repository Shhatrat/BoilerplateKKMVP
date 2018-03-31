package com.shhatrat.boilerplate_kkmvp.di

import com.shhatrat.boilerplate_kkmvp.di.modules.managerModule
import com.shhatrat.boilerplate_kkmvp.di.modules.mvpModule
import com.shhatrat.boilerplate_kkmvp.di.modules.serviceModule

/**
 * Created by szymon on 23/12/17.
 */
object Modules{
    fun get() = listOf(mvpModule, managerModule, serviceModule, adapterModule)
}