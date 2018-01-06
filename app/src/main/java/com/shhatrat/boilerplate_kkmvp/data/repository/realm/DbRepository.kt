package com.shhatrat.boilerplate_kkmvp.data.repository.realm

import com.shhatrat.boilerplate_kkmvp.data.model.PersonRealm

/**
 * Created by szymon on 6/01/18.
 */
interface DbRepository{
    fun savePerson(person: PersonRealm)
    fun getPerson(): PersonRealm?
    fun getAll(): List<PersonRealm?>
}