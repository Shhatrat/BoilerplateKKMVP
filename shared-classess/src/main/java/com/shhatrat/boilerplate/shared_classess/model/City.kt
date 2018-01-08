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
@Entity()
data class City(
        @ColumnInfo(name = "name")
        var name: String?): PaperParcelable {
    constructor() : this(null)

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false) var id: Long = 0

    companion object {
        @JvmField val CREATOR = PaperParcelCity.CREATOR }
}