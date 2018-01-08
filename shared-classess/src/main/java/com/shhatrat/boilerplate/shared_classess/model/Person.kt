package com.shhatrat.boilerplate_kkmvp.data.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by szymon on 23/12/17.
 */
@PaperParcel
@Entity(tableName = "Person")
data class Person(
        @ColumnInfo(name = "name")
        var name: String?,
        @ColumnInfo(name = "idCard")
        var idCard: Int?): PaperParcelable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0

    companion object {
        @JvmField val CREATOR = PaperParcelPerson.CREATOR }
}