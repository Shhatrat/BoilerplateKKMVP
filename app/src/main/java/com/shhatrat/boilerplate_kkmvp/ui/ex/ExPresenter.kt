package com.shhatrat.boilerplate_kkmvp.ui.ex

import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate_kkmvp.data.db.PersonDao
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter
import io.reactivex.rxkotlin.addTo

/**
 * Created by szymon on 23/12/17.
 */
class ExPresenter
constructor(private val dao: PersonDao): BasePresenter<ExContract.IView>(), ExContract.IPresenter<ExContract.IView>{

    override fun getTime() {
        dao.insertTask(Person("test", 123))
        dao.getAllTasks()
                .subscribe({
                    view.showTime(it.size.toString())
                },{
                    view.showTime("error")
                })
                .addTo(subscriptions)
    }

}