package com.shhatrat.boilerplate_kkmvp.ui.old.wear

import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 27/12/17.
 */
interface WearContract{
    interface IView: MvpView {
        fun getMessage(person: Person)
    }
    interface IPresenter<in T: MvpView>: Presenter<T> {
        fun sendMessage(person: Person)
    }
}