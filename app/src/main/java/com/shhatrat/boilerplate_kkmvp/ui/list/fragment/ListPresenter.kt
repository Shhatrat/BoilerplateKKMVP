package com.shhatrat.boilerplate_kkmvp.ui.list.fragment

import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

/**
 * Created by szymon on 10/01/18.
 */
class ListPresenter
constructor(private val settingsRepositiory: SettingsRepositiory,
            private val apiManager: ApiManager): BasePresenter<ListContract.IView>(), ListContract.IPresenter<ListContract.IView>{
    override fun getList() {
        apiManager
                .getListOfStation()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if(it?.isNotEmpty()==true)
                        prepareList(it)
                },{
                    view.showError(it.message?:"Error")
                })
                .addTo(subscriptions)
    }

    private fun prepareList(list: List<BasicStation>) {
        val mapWithPair = list
                .sortedBy { it.stationName }
                .map { mapIt -> Pair(mapIt, settingsRepositiory.favourites.map { it -> it.toInt() }.contains(mapIt.id)) }
        view.setList(mapWithPair)
    }

    override fun addToFavourite(id: Int) {
        settingsRepositiory.favourites = settingsRepositiory.favourites.plus(id.toString())
    }

    override fun removeFromFavourite(id: Int) {
        settingsRepositiory.favourites = settingsRepositiory.favourites.minus(id.toString())
    }

    override fun sendToWear(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}