package com.shhatrat.boilerplate_kkmvp.ui.ex

import com.shhatrat.boilerplate_kkmvp.data.db.PersonDao
import com.shhatrat.boilerplate_kkmvp.data.model.Person
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter

/**
 * Created by szymon on 23/12/17.
 */
class ExPresenter
constructor(private val dao: PersonDao): BasePresenter<ExContract.IView>(), ExContract.IPresenter<ExContract.IView>{

    override fun getTime() {
        dao.insertTask(Person("test", 123))
        view.showTime(dao.getAllTasks().size.toString())
    }

}