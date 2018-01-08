package com.shhatrat.boilerplate.shared_classess.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
/**
 * Created by szymon on 8/01/18.
 */
@PaperParcel
@Entity(tableName = "Person")
data class Person(
        @ColumnInfo(name = "name")
        var name: String?,
        @ColumnInfo(name = "idCard")
        var idCard: Int?): PaperParcelable {
    constructor() : this(null, null)

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0

    companion object {
        @JvmField val CREATOR = PaperParcelPerson.CREATOR }
}