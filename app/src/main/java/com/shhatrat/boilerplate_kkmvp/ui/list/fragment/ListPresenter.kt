package com.shhatrat.boilerplate_kkmvp.ui.list.fragment

import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.rxkotlin.addTo

/**
 * Created by szymon on 10/01/18.
 */
class ListPresenter
constructor(private val settingsRepositiory: SettingsRepositiory,
            private val apiManager: ApiManager): BasePresenter<ListContract.IView>(), ListContract.IPresenter<ListContract.IView>{
    override fun getList() {
        apiManager
                .getListOfStation()
                .subscribe({
                    if(it?.isNotEmpty()==true)
                        view.setList(it)
                },{
                    view.showError(it.message?:"Error")
                })
                .addTo(subscriptions)
    }

    override fun addToFavourite(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeFromFavourite(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendToWear(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}