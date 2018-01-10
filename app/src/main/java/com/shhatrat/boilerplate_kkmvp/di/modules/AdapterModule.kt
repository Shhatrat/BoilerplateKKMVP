package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.ui.list.adapter.BasicStationAdapter
import com.shhatrat.boilerplate_kkmvp.ui.old.base.adapter.simple.SimpleListAdapter
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 25/12/17.
 */
class AdapterModule: AndroidModule() {
    override fun context() = applicationContext {
        provide { SimpleListAdapter() }
        provide { BasicStationAdapter() }
    }
}