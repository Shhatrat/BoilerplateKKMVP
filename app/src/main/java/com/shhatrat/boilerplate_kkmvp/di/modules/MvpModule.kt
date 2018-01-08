package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.db.MyDatabase
import com.shhatrat.boilerplate_kkmvp.data.repository.UserRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiContract
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiPresenter
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExActivity
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 24/12/17.
 */
class MvpModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { getRepo() }
        provide { ApiPresenter(get()) } bind ApiContract.IPresenter::class
        provide { ExPresenter( get()) } bind ExContract.IPresenter::class
    }

    fun getRepo(): UserRepositiory {
        return UserRepositiory()
    }
}