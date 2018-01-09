package com.shhatrat.boilerplate_kkmvp.ui.old.api

import com.shhatrat.boilerplate_kkmvp.data.manager.api.ApiManager
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

/**
 * Created by szymon on 25/12/17.
 */
class ApiPresenter
constructor(private val apiManager: ApiManager): BasePresenter<ApiContract.IView>(), ApiContract.IPresenter<ApiContract.IView>{

    override fun getPerson() {
        apiManager
                .getSensorsOfStation(52)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it
                }
                , {}).addTo(subscriptions)
    }

}