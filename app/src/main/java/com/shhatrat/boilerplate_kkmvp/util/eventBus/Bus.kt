package com.shhatrat.boilerplate_kkmvp.util.eventBus

import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.Observable

/**
 * Created by szymon on 25/12/17.
 */
object RxBus{

    enum class Msg{
        LOGOUT, LOGIN
    }

    private val relay: Relay<Msg> = PublishRelay.create<Msg>().toSerialized()

    fun post(event: Msg) {
        relay.accept(event)
    }

    fun receive(): Observable<Msg> {
        return relay
    }
}