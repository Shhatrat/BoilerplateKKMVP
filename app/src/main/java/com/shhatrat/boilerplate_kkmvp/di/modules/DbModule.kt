package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.data.repository.realm.DbRepository
import com.shhatrat.boilerplate_kkmvp.data.repository.realm.DbRepositoryImpl
import io.realm.Realm
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * Created by szymon on 6/01/18.
 */
val dbModule: Module = module {
        single { getRealm() }
        single { DbRepositoryImpl() } bind DbRepository::class
    }
    fun getRealm() = Realm.getDefaultInstance()