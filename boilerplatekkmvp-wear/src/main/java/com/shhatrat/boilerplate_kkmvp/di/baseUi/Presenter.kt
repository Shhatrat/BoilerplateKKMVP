package com.shhatrat.boilerplate_kkmvp.di.baseUi

/**
 * Created by szymon on 23/12/17.
 */
interface Presenter<in V : MvpView> {
    fun attachView(view: V)
    fun detachView()
}