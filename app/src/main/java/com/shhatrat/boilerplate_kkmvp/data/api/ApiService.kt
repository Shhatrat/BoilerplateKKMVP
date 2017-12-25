package com.shhatrat.boilerplate_kkmvp.data.api

import com.shhatrat.boilerplate_kkmvp.data.model.Person
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by szymon on 25/12/17.
 */
interface ApiService{
    companion object {
        val URL = "https://raw.githubusercontent.com/Shhatrat/BoilerplateKKMVP/"
    }

    @GET("addon/RestApi/person")
    fun getPerson(
    ): Observable<Response<Person>>
}