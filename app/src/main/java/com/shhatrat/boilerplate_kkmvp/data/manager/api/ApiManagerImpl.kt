package com.shhatrat.boilerplate_kkmvp.data.manager.api

import com.shhatrat.boilerplate_kkmvp.data.api.ApiService

/**
 * Created by szymon on 25/12/17.
 */
class ApiManagerImpl(private val apiService: ApiService): ApiManager{

    override fun getPerson() = apiService.getPerson().map { it.body() }
}