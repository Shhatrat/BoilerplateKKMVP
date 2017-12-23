package com.shhatrat.boilerplate_kkmvp.data.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by szymon on 23/12/17.
 */
@PaperParcel
data class Person(
        val name: String,
        @field:SerializedName("id_card")
        val idCard: Int
): PaperParcelable {
        companion object {
                //change "PaperParcelPerson" to proper (based on name) data class name
                @JvmField val CREATOR = PaperParcelPerson.CREATOR }
}