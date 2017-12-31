package com.shhatrat.boilerplate_kkmvp.data.manager.wear

import com.google.gson.Gson
import com.patloew.rxwear.RxWear
import com.shhatrat.boilerplate.shared_classess.Constraints
import com.shhatrat.boilerplate.shared_classess.model.Person
import io.reactivex.Observable

/**
 * Created by szymon on 26/12/17.
 */
class WearManagerImpl(private val rxWear : RxWear): WearManager{

    override fun sendData(person: Person): Observable<Int> {
        return rxWear.message().sendDataMapToAllRemoteNodes(Constraints.sendPersonPath)
                .putString(Constraints.person, Gson().toJson(person))
                .toObservable()
    }

    override fun getData(person: Person) {
    }

    override fun checkConnection() =  rxWear.checkConnection()
}