package com.shhatrat.boilerplate_kkmvp.data.manager.api

import com.shhatrat.boilerplate_kkmvp.data.api.ApiService
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by szymon on 25/12/17.
 */
class ApiManagerImpl(private val apiService: ApiService): ApiManager{
    override fun getDataOfStation(id: Int)= apiService.getDataOfStation(id).map { it.body() }.compose(schedulers())
    override fun getSensorsOfStation(id: Int) = apiService.getSensorsOfStation(id).map { it.body() }.compose(schedulers())
    override fun getListOfStation()= apiService.getListOfStation().map { it.body() }.compose(schedulers())
    override fun getPerson() = apiService.getPerson().map { it.body() }.compose(schedulers())

    private fun <T> schedulers(): ObservableTransformer<T, T> {
       return ObservableTransformer {
           it.subscribeOn(Schedulers.newThread())
           it.observeOn(AndroidSchedulers.mainThread())
       }
    }
}