package com.shhatrat.boilerplate_kkmvp.data.manager.wear

import com.shhatrat.boilerplate.shared_classess.model.Person
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by szymon on 26/12/17.
 */
interface WearManager{
    fun sendData(person: Person): Observable<Int>
    fun getData(person: Person)
    fun checkConnection(): Completable
}