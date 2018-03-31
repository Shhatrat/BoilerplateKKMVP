package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.UserRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiContract
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiPresenter
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExActivity
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExPresenter
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by szymon on 24/12/17.
 */
val mvpModule: Module = applicationContext {
    bean { getRepo() }
    factory { ExPresenter(get(ExActivity.INJECT_NAME), get()) } bind ExContract.IPresenter::class
    factory { ApiPresenter(get()) }     bind ApiContract.IPresenter::class
}

fun getRepo(): UserRepositiory {
    return UserRepositiory()
}
