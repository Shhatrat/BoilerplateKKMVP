package com.shhatrat.boilerplate.shared_classess.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by szymon on 8/01/18.
 */
@PaperParcel
data class StationData(val id: Number?,
                val stCalcDate: String?,
                @field:SerializedName("stIndexLevel")
                val stIndexLevel: Detail?,
                val stSourceDataDate: String?,
                val so2CalcDate: String?,
                @field:SerializedName("so2IndexLevel")
                val so2IndexLevel: Detail?,
                val so2SourceDataDate: String?,
                val no2CalcDate: String?,
                @field:SerializedName("no2IndexLevel")
                val no2IndexLevel: Detail?,
                val no2SourceDataDate: String?,
                val coCalcDate: String?,
                @field:SerializedName("coIndexLevel")
                val coIndexLevel: Detail?,
                val coSourceDataDate: String?,
                val pm10CalcDate: String?,
                @field:SerializedName("pm10IndexLevel")
                val pm10IndexLevel: Detail?,
                val pm10SourceDataDate: String?,
                val pm25CalcDate: String?,
                @field:SerializedName("pm25IndexLevel")
                val pm25IndexLevel: Detail?,
                val pm25SourceDataDate: String?,
                val o3CalcDate: String?,
                @field:SerializedName("o3IndexLevel")
                val o3IndexLevel: Detail?,
                val o3SourceDataDate: String?,
                val c6h6CalcDate: String?,
                @field:SerializedName("c6h6IndexLevel")
                val c6h6IndexLevel: Detail?,
                val c6h6SourceDataDate: String?): PaperParcelable{
    companion object {
        @JvmField val CREATOR = PaperParcelStationData.CREATOR }
}
@PaperParcel
data class Detail(val id: Number?, val indexLevelName: String?):PaperParcelable{
    companion object {
        @JvmField val CREATOR = PaperParcelDetail.CREATOR }
}