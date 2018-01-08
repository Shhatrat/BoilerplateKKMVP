package com.shhatrat.boilerplate_kkmvp.di.modules

import android.arch.persistence.room.Room
import com.shhatrat.boilerplate_kkmvp.data.db.MyDatabase
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 7/01/18.
 */
class RoomModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { getAppDatabase() }
    }

    fun getAppDatabase()= Room.databaseBuilder(context, MyDatabase::class.java, "my-todo-db").allowMainThreadQueries().build().personDao()
}