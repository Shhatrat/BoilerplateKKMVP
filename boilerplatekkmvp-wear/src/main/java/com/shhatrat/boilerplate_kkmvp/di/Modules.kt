package com.shhatrat.boilerplate_kkmvp.di

import com.shhatrat.boilerplate_kkmvp.di.modules.managerModule
import com.shhatrat.boilerplate_kkmvp.di.modules.mvpModule
import com.shhatrat.boilerplate_kkmvp.di.modules.wearModule

/**
 * Created by szymon on 23/12/17.
 */
object Modules{
    fun get() = listOf(mvpModule, managerModule, wearModule)
}