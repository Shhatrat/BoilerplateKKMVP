package com.shhatrat.boilerplate_kkmvp.ui.old.base.adapter.simple

/**
 * Created by szymon on 24/12/17.
 */
data class SimpleListModel(
        val text: String?,
        var imageId: Int?=null,
        var onClickFun: (() -> Unit)?=null
)