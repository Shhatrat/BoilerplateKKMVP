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
data class BasicStation(
        @ColumnInfo()
        var stationName: String?,
        @ColumnInfo()
        val gegrLat: Double?,
        @ColumnInfo()
        val gegrLon: Double?,
        @ColumnInfo()
        val city: City?,
        @ColumnInfo()
        val addressStreet: String?
        ): PaperParcelable {
    constructor() : this(null, null, null, null, null)

    @ColumnInfo()
    @PrimaryKey(autoGenerate = false)
    var id: Long = 0
    companion object {
        @JvmField val CREATOR = PaperParcelBasicStation.CREATOR }
}
