package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.UserRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExPresenter
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by szymon on 24/12/17.
 */
val mvpModule: Module = applicationContext {
    bean { getRepo() }
    factory { ExPresenter(get()) } bind ExContract.IPresenter::class
}

fun getRepo(): UserRepositiory {
    return UserRepositiory()
}
