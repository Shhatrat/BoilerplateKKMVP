package com.shhatrat.boilerplate_kkmvp.di.modules

import android.arch.persistence.room.Room
import com.shhatrat.boilerplate_kkmvp.data.db.MyDatabase
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by szymon on 7/01/18.
 */
val roomModule: Module = applicationContext {
        bean { Room.databaseBuilder(get(), MyDatabase::class.java, "my-todo-db").allowMainThreadQueries().build().personDao() }
}

