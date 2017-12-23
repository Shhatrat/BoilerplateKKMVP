package com.shhatrat.boilerplate_kkmvp.ui.ex

import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter

/**
 * Created by szymon on 23/12/17.
 */
class ExPresenter
constructor(private val manager: DataManager): BasePresenter<ExContract.IView>(), ExContract.IPresenter<ExContract.IView>{

    override fun getTime() {
        view.showTime(manager.getCurrentTime())
    }

}