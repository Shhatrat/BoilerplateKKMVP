package com.shhatrat.boilerplate_kkmvp.data.manager.api

import com.shhatrat.boilerplate_kkmvp.data.model.Person
import io.reactivex.Observable

/**
 * Created by szymon on 25/12/17.
 */
interface ApiManager{
    fun getPerson(): Observable<Person?>
}