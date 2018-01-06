package com.shhatrat.boilerplate_kkmvp.data.model

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * Created by szymon on 6/01/18.
 */
@RealmClass
open class PersonRealm(var name: String? = null,
                       var idCard: Int? = null) : RealmModel{

    fun Person.toRealm() = PersonRealm(this.name, this.idCard)
    fun fromRealm() = Person(this.name?:"", this.idCard?:0)
}