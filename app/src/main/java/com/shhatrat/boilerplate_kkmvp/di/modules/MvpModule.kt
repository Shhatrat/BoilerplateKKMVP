package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.UserRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExActivity
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
        provide { ExPresenter(get(ExActivity.INJECT_NAME), get()) } bind ExContract.IPresenter::class
        provide { WearPresenter(get()) } bind WearContract.IPresenter::class
    }

    fun getRepo(): UserRepositiory {
        return UserRepositiory()
    }
}