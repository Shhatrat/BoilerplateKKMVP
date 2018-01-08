package com.shhatrat.boilerplate_kkmvp.data.api

import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate.shared_classess.model.StationData
import com.shhatrat.boilerplate.shared_classess.model.StationSensor
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by szymon on 25/12/17.
 */
interface ApiService{

    @GET("addon/RestApi/person")
    fun getPerson(
    ): Observable<Response<Person>>

    @GET("station/findAll")
    fun getListOfStation(
    ): Observable<Response<List<BasicStation>>>

    @GET("aqindex/getIndex/{id}")
    fun getDataOfStation(
            @Path("id") id: Int
    ): Observable<Response<StationData>>

    @GET("station/sensors/{id}")
    fun getSensorsOfStation(
            @Path("id") id: Int
    ):Observable<Response<List<StationSensor>>>
}