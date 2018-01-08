package com.shhatrat.boilerplate_kkmvp.data.manager.api


import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate.shared_classess.model.StationData
import com.shhatrat.boilerplate.shared_classess.model.StationSensor
import io.reactivex.Observable

/**
 * Created by szymon on 25/12/17.
 */
interface ApiManager{
    fun getPerson(): Observable<Person?>
    fun getListOfStation(): Observable<List<BasicStation>?>
    fun getDataOfStation(id:Int): Observable<StationData?>
    fun getSensorsOfStation(id:Int): Observable<List<StationSensor>?>
}