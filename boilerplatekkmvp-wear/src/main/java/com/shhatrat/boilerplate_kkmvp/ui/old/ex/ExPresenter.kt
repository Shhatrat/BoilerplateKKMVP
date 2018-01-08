package com.shhatrat.boilerplate_kkmvp.ui.old.ex

import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.repository.UserRepositiory
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter

/**
 * Created by szymon on 23/12/17.
 */
class ExPresenter
constructor(private val manager: DataManager, private val repositiory: UserRepositiory): BasePresenter<ExContract.IView>(), ExContract.IPresenter<ExContract.IView>{

    override fun getTime() {
        repositiory.name = "${repositiory.name?:" :> "} ${manager.getCurrentTime()}"
        view.showTime(repositiory.name?:"no time")
    }

}