package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiContract
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiPresenter
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExPresenter
import com.shhatrat.boilerplate_kkmvp.ui.wear.WearContract
import com.shhatrat.boilerplate_kkmvp.ui.wear.WearPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 24/12/17.
 */
class MvpModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { getRepo() }
        provide { WearPresenter(get()) } bind WearContract.IPresenter::class
        provide { ApiPresenter(get()) } bind ApiContract.IPresenter::class
        provide { ExPresenter( get()) } bind ExContract.IPresenter::class
    }

    fun getRepo(): SettingsRepositiory {
        return SettingsRepositiory()
    }
}