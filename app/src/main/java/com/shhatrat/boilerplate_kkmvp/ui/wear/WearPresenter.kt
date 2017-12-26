package com.shhatrat.boilerplate_kkmvp.ui.wear

import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManager
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter

/**
 * Created by szymon on 27/12/17.
 */
class WearPresenter
constructor(private val wearManager: WearManager): BasePresenter<WearContract.IView>(), WearContract.IPresenter<WearContract.IView>{

    override fun sendMessage(input: String) {

    }

}