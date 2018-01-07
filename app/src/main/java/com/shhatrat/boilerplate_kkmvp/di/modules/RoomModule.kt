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
//        provide { getMyDb() }
//        provide { PersonDao() }
    }

//    fun getMyDb() = getAppDatabase().personDao()
    fun getAppDatabase()= Room.databaseBuilder(context, MyDatabase::class.java, "my-todo-db").allowMainThreadQueries().build().personDao()
//    fun oo(){
//       val pp =  Room.databaseBuilder(context, MyDatabase::class.java, "my-todo-db").allowMainThreadQueries().build()
//        pp.
//    }
}