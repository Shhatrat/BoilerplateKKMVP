package com.shhatrat.boilerplate_kkmvp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shhatrat.boilerplate_kkmvp.data.model.Person


/**
 * Created by szymon on 7/01/18.
 */
@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase(){
    abstract fun personDao(): PersonDao

}