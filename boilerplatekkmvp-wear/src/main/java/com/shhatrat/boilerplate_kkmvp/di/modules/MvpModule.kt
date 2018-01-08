package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.UserRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.old.ex.ExActivity
import com.shhatrat.boilerplate_kkmvp.ui.old.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.old.ex.ExPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 24/12/17.
 */
class MvpModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { getRepo() }
        provide { ExPresenter(get(ExActivity.INJECT_NAME), get()) } bind ExContract.IPresenter::class
    }

    fun getRepo(): UserRepositiory {
        return UserRepositiory()
    }
}