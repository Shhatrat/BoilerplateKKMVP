package com.shhatrat.boilerplate_kkmvp.ui.api

import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 25/12/17.
 */
interface ApiContract{
    interface IView: MvpView{
        fun showData(person: Person?)
    }
    interface IPresenter<in T: MvpView>: Presenter<T> {
        fun getPerson()
    }
}