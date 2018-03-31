package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.ui.base.adapter.simple.SimpleListAdapter
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by szymon on 25/12/17.
 */
val adapterModule: Module = applicationContext {
        bean { SimpleListAdapter() }
    }