package com.shhatrat.boilerplate_kkmvp.data.manager.api

import com.shhatrat.boilerplate_kkmvp.data.api.ApiService

/**
 * Created by szymon on 25/12/17.
 */
class ApiManagerImpl(private val apiService: ApiService): ApiManager{
    override fun getDataOfStation(id: Int)= apiService.getDataOfStation(id).map { it.body() }
    override fun getSensorsOfStation(id: Int) = apiService.getSensorsOfStation(id).map { it.body() }
    override fun getListOfStation()= apiService.getListOfStation().map { it.body() }

    override fun getPerson() = apiService.getPerson().map { it.body() }
}