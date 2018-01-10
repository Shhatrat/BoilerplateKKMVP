package com.shhatrat.boilerplate_kkmvp.ui.list.fragment

import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate_kkmvp.di.baseUi.MvpView
import com.shhatrat.boilerplate_kkmvp.di.baseUi.Presenter

/**
 * Created by szymon on 10/01/18.
 */
interface ListContract{
    interface IView: MvpView {
        fun setList(list: List<Pair<BasicStation, Boolean>>)
        fun updateList(item: BasicStation)
    }
    interface IPresenter<in T: MvpView>: Presenter<T> {
        fun getList()
        fun addToFavourite(id: Int)
        fun removeFromFavourite(id: Int)
        fun sendToWear(id: Int)
    }
}