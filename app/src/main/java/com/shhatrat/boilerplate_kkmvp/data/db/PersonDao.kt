package com.shhatrat.boilerplate_kkmvp.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.shhatrat.boilerplate_kkmvp.data.model.Person

/**
 * Created by szymon on 7/01/18.
 */
@Dao interface PersonDao{

    @Query("select * from person")
    fun getAllTasks(): List<Person>

    @Delete
    fun deleteTask(person: Person)

    @Insert(onConflict = REPLACE)
    fun insertTask(person: Person)
}