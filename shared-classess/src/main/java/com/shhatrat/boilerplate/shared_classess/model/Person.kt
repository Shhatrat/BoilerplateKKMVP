package com.shhatrat.boilerplate.shared_classess.model

import com.google.gson.annotations.SerializedName

/**
 * Created by szymon on 27/12/17.
 */
data class Person(
        val name: String,
        @field:SerializedName("id_card")
        val idCard: Int
)