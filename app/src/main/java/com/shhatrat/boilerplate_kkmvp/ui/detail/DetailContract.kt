package com.shhatrat.boilerplate_kkmvp.ui.detail

import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 10/01/18.
 */
interface DetailContract{
    interface IView: MvpView {
        fun updateView()
    }
    interface IPresenter<in T: MvpView>: Presenter<T> {
        fun updateData(id: Int)
    }
}