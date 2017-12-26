package com.shhatrat.boilerplate_kkmvp.ui.wear

import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 27/12/17.
 */
interface WearContract{
    interface IView: MvpView {
        fun getMessage(input: String)
    }
    interface IPresenter<in T: MvpView>: Presenter<T> {
        fun sendMessage(input: String)
    }
}