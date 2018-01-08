package com.shhatrat.boilerplate_kkmvp.ui.settings

import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManager
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.rxkotlin.addTo

/**
 * Created by szymon on 9/01/18.
 */
class SettingsPresenter
constructor(private val settingsRepositiory: SettingsRepositiory, private val wearManager: WearManager): BasePresenter<SettingsContract.IView>(), SettingsContract.IPresenter<SettingsContract.IView>{

    override fun getData() {
        view.setView(
                settingsRepositiory.wear,
                settingsRepositiory.backgroundService,
                settingsRepositiory.updateEveryTime)
        checkShowWear()
    }

    override fun isWearConnected() {
        wearManager
                .checkConnection()
                .subscribe({
                    view.showConnection("Success")
                }, {
                    view.showConnection("false")
                })
                .addTo(subscriptions)
    }

    override fun setWear(e: Boolean) {
        settingsRepositiory.wear = e
        checkShowWear()
    }

    private fun checkShowWear(){
        if(settingsRepositiory.wear)
            view.showWear()
        else
            view.hideWear()
    }

    override fun setService(e: Boolean) {
        settingsRepositiory.backgroundService = e
    }

    override fun setUpdate(e: Boolean) {
        settingsRepositiory.updateEveryTime = e
    }

}
