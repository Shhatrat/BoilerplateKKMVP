package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.service.MainService
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * Created by szymon on 1/01/18.
 */
val serviceModule: Module = module {
        factory { MainService() }
    }