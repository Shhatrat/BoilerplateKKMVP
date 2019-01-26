package com.shhatrat.boilerplate_kkmvp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.shhatrat.boilerplate_kkmvp.data.model.Person
import io.reactivex.Flowable

/**
 * Created by szymon on 7/01/18.
 */
@Dao
interface PersonDao{

    @Query("select * from person")
    fun getAllTasks(): Flowable<List<Person>>

    @Delete
    fun deleteTask(person: Person)

    @Insert(onConflict = REPLACE)
    fun insertTask(person: Person)
}