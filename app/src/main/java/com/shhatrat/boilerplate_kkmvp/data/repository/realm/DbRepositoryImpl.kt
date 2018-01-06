package com.shhatrat.boilerplate_kkmvp.data.repository.realm

import com.shhatrat.boilerplate_kkmvp.data.model.PersonRealm
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.queryLast
import com.vicpin.krealmextensions.save

/**
 * Created by szymon on 6/01/18.
 */
class DbRepositoryImpl: DbRepository{
    override fun getAll(): List<PersonRealm?> {
        return PersonRealm().queryAll()
    }

    override fun getPerson(): PersonRealm? {
       return PersonRealm().queryLast()
    }

    override fun savePerson(person: PersonRealm) {
        person.save()
    }

}