package com.shhatrat.boilerplate_kkmvp.ui.ex

import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 23/12/17.
 */
interface ExContract{
    interface IView: MvpView{
        fun showTime(time: String)
    }
    interface IPresenter<in T:MvpView>: Presenter<T>{
        fun getTime()
    }
}