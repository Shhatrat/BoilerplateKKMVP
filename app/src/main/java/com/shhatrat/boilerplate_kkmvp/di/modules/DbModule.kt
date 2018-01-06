package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.realm.DbRepository
import com.shhatrat.boilerplate_kkmvp.data.repository.realm.DbRepositoryImpl
import io.realm.Realm
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 6/01/18.
 */
class DbModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { getRealm() }
        provide { DbRepositoryImpl() } bind DbRepository::class
    }

    fun getRealm() = Realm.getDefaultInstance()
}