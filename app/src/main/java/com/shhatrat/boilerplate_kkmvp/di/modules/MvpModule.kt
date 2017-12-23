package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.ui.ex.ExActivity
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 24/12/17.
 */
class MvpModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { ExPresenter(get(ExActivity.INJECT_NAME)) } bind ExContract.IPresenter::class
    }
}