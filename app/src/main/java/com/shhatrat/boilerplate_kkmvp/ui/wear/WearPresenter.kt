package com.shhatrat.boilerplate_kkmvp.ui.wear

import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate_kkmvp.data.manager.wear.WearManager
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit

/**
 * Created by szymon on 27/12/17.
 */
class WearPresenter
constructor(private val wearManager: WearManager): BasePresenter<WearContract.IView>(), WearContract.IPresenter<WearContract.IView>{

    override fun sendMessage(person: Person) {
        wearManager
                .sendData(person)
                .timeout(3, TimeUnit.SECONDS)
                .subscribe({
                    it.dec()
                },{
                    it.message
                })
                .addTo(subscriptions)
    }

}