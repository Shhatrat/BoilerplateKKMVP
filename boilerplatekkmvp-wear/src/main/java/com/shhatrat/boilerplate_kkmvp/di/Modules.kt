package com.shhatrat.boilerplate_kkmvp.di

import com.shhatrat.boilerplate_kkmvp.di.modules.ManagerModule
import com.shhatrat.boilerplate_kkmvp.di.modules.MvpModule
import com.shhatrat.boilerplate_kkmvp.di.modules.WearModule
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 23/12/17.
 */
object Modules{
    fun get() = listOf<AndroidModule>(MvpModule(), ManagerModule(), WearModule())
}