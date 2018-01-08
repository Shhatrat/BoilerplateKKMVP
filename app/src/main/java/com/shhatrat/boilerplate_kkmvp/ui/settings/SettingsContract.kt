package com.shhatrat.boilerplate_kkmvp.ui.settings

import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 9/01/18.
 */
interface SettingsContract{
    interface IView: MvpView {
        fun showWear()
        fun hideWear()
        fun setView(enableWear: Boolean, enableService: Boolean, update: Boolean)
        fun showConnection(msg: String)
    }
    interface IPresenter<in T: MvpView>: Presenter<T> {
        fun getData()
        fun isWearConnected()
        fun setWear(e: Boolean)
        fun setService(e: Boolean)
        fun setUpdate(e: Boolean)
    }
}