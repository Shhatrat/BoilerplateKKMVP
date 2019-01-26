package com.shhatrat.boilerplate_kkmvp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by szymon on 23/12/17.
 */

@Parcelize
@Entity(tableName = "Person")
data class Person(
        @ColumnInfo(name = "name")
        var name: String?,
        @ColumnInfo(name = "idCard")
        var idCard: Int?): Parcelable {
        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = true) var id: Long = 0
}