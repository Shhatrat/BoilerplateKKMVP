package com.shhatrat.boilerplate_kkmvp.ui.detail

import com.shhatrat.boilerplate.shared_classess.model.StationData
import com.shhatrat.boilerplate.shared_classess.model.StationSensor
import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

/**
 * Created by szymon on 10/01/18.
 */
class DetailPresenter
constructor(private val apiManager: ApiManager): BasePresenter<DetailContract.IView>(), DetailContract.IPresenter<DetailContract.IView>{


    override fun updateData(id: Int) {
        Observable.zip(
                apiManager.getDataOfStation(id),
                apiManager.getSensorsOfStation(id),
                BiFunction<
                        StationData?,
                        List<StationSensor>?,
                        Pair<StationData?, List<StationSensor>?>>
                { t1, t2 -> Pair(t1,t2) })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.updateView()
                },{
                    view.showError(it.message?:"error")
                })
                .addTo(subscriptions)
    }

}