package com.shhatrat.boilerplate_kkmvp.ui.ex

import com.shhatrat.boilerplate_kkmvp.data.manager.data.DataManager
import com.shhatrat.boilerplate_kkmvp.data.model.Person
import com.shhatrat.boilerplate_kkmvp.data.model.PersonRealm
import com.shhatrat.boilerplate_kkmvp.data.repository.realm.DbRepository
import com.shhatrat.boilerplate_kkmvp.di.baseUi.BasePresenter

/**
 * Created by szymon on 23/12/17.
 */
class ExPresenter
constructor(private val manager: DataManager, private val dbRepository: DbRepository): BasePresenter<ExContract.IView>(), ExContract.IPresenter<ExContract.IView>{

    override fun getTime() {
        val person = dbRepository.getPerson()
        if(person!=null)
            dbRepository.savePerson(PersonRealm("${person.name} dd ", person.idCard!!))
           else
        dbRepository.savePerson(PersonRealm("ee ",123 ))

        view.showTime(person?.name?:"nie ma :( ")
    }

}